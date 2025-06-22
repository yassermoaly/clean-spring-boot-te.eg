package client.apis.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import client.aps.filter.RateLimitingFilter;
import models.configuration.RateLimitProperties;

@Configuration
public class RateLimitConfig {

    @Bean
    FilterRegistrationBean<RateLimitingFilter> rateLimitingFilter(RateLimitProperties rateLimitProperties) {
        FilterRegistrationBean<RateLimitingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RateLimitingFilter(rateLimitProperties));
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}