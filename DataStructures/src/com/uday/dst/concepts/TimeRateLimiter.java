package com.uday.dst.concepts;

import java.util.concurrent.*;

public class TimeRateLimiter {

    private Semaphore semaphore;

    private int maxPermits;

    public TimeRateLimiter init(int maxPermits, int time, TimeUnit timeUnit) {
        TimeRateLimiter timeRateLimiter = new TimeRateLimiter(maxPermits);
        this.scheduledRefill(time, timeUnit);
        return timeRateLimiter;
    }


    public TimeRateLimiter(int maxPermits) {
        this.maxPermits = maxPermits;
        semaphore = new Semaphore(maxPermits);
    }

    public boolean isAllowed(int permits, long waitTimeMs) throws InterruptedException {
        return semaphore.tryAcquire(permits, waitTimeMs, TimeUnit.MILLISECONDS);
    }

    private void refill() {
        semaphore.release(maxPermits - semaphore.availablePermits());
    }

    public void scheduledRefill(int time, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            refill();
        }, 0, time, timeUnit);
    }
}
