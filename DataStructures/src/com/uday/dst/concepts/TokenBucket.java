package com.uday.dst.concepts;

public class TokenBucket {

    long maxTokens;

    double currentTokens;

    long refillRate; // per min

    long lastRefillTimeInMs;


    public TokenBucket(long maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        currentTokens = maxTokens;
        lastRefillTimeInMs = System.currentTimeMillis();
    }

    public synchronized boolean isAllowed(int tokens) {
        refill();
        if (currentTokens - tokens > 0) {
            currentTokens = -tokens;
            return true;
        }
        return false;
    }

    private void refill() {
        long diff = System.currentTimeMillis() - lastRefillTimeInMs;
        double tokens = refillRate * diff / 1000;
        currentTokens = Math.min(maxTokens, (currentTokens + tokens));
    }
}
