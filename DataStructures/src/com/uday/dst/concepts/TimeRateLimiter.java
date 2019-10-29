package com.uday.dst.concepts;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class RateLimiter {

    private long refillRate;

    private Semaphore semaphore;

    private int maxPermits;


    public RateLimiter(int maxPermits){
        this.maxPermits = maxPermits;
        Semaphore semaphore = new Semaphore(maxPermits);
    }

    public synchronized boolean isAllowed(int permits){
        return semaphore.tryAcquire(permits);
    }

    public void scheduledReplinshment(){
        ThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.execute(()-{
            System.nanoTime();
        });
        scheduler.shutdown();
    }
}
