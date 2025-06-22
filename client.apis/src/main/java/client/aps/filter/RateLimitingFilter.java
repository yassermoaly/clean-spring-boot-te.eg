package client.aps.filter;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.configuration.RateLimitProperties;

public class RateLimitingFilter implements Filter {	
	private final Cache<String, Bucket> cache;
    private final RateLimitProperties properties;

    public RateLimitingFilter(RateLimitProperties properties) {
        this.properties = properties;
        this.cache = Caffeine.newBuilder()
                .expireAfterAccess(properties.getCacheExpiryMinutes(), TimeUnit.MINUTES)
                .build();
    }
	
    private Bucket createNewBucket() {
         return Bucket.builder()
            .addLimit(limit -> limit.capacity(properties.getCapacity()).refillGreedy(properties.getTokens(), Duration.ofMinutes(properties.getDurationMinutes())))
            .build();
    }
    
    private Bucket resolveBucket(String ip) {
        return cache.get(ip, key -> {
            return createNewBucket();
        });
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String ip = extractClientIp(httpRequest);
        Bucket bucket = resolveBucket(ip);       

        // tryConsume returns false immediately if no tokens available with the bucket
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if (probe.isConsumed()) {
            // the limit is not exceeded
        	 httpResponse.setHeader("X-Rate-Limit-Remaining", "" + probe.getRemainingTokens());
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // limit is exceeded            
            httpResponse.setContentType("text/plain");
            httpResponse.setStatus(429);
            httpResponse.getWriter().append("Too many requests");
        }
    }
    
    private String extractClientIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        return xfHeader != null ? xfHeader.split(",")[0] : request.getRemoteAddr();
    }
}