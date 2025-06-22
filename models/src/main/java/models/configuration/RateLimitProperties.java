package models.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rate.limit")
public class RateLimitProperties {
    private int capacity;
    private int tokens;
    private int durationMinutes;
    private int cacheExpiryMinutes;

    // Getters and setters
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getTokens() {
        return tokens;
    }
    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
    public int getCacheExpiryMinutes() {
        return cacheExpiryMinutes;
    }
    public void setCacheExpiryMinutes(int cacheExpirySeconds) {
        this.cacheExpiryMinutes = cacheExpirySeconds;
    }
}