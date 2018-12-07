package com.uday.dst.concepts;
import java.io.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
    
    
    class RateLimiterMap{
        private Map<Integer,RateLimiter> userRateLimiters; 

        public RateLimiterMap(){
            this.userRateLimiters = new HashMap<>();
        }

        public void initRateLimiter(int userId, License license){
            RateLimiter rl = new RateLimiter(license,userId);
            userRateLimiters.put(userId,rl);
        }

        public RateLimiter getUserRateLimiter(int userId){
            return userRateLimiters.get(userId);
        }
    }
    
    class Request {

        private Long accessTime;
        private Integer userId;  

        public Long getRequestTime(){
            return accessTime;
        }

    }


    class RateLimiter implements Runnable{
        private License license; 
        private int userId; 
        private Long startTrackingTime;
        private AtomicInteger counter; 
        private BlockingQueue<Request> queue; 
        Object lock = new Object();

        public RateLimiter(License l, int u){
            this.license = l;
            this.userId = u; 
            counter = new AtomicInteger(0);
            startTrackingTime = System.currentTimeMillis();
            queue = new LinkedBlockingQueue<>();
        }

        public void run(){
            while(true){
                while(queue.isEmpty()){
                    try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }
				boolean pass = evaluateReq(queue.peek());
				if(pass){
					queue.poll();
				}
            }
        }

        public void processReq(Request req) throws InterruptedException{
            queue.put(req);
            lock.notifyAll();
        }


        public boolean evaluateReq(Request request){
            if(isAllowed(request.getRequestTime())){
               return true;  
            }
            return false; 

        }

        public boolean isAllowed(Long reqTime){
        	long currentTime = System.currentTimeMillis();
        	if(reqTime.longValue()-currentTime>=20000){
        		return false;
        	}
        	long diff = reqTime.longValue()-startTrackingTime.longValue(); 
        	if(diff>1000){
                startTrackingTime = reqTime; 
                counter = new AtomicInteger(0);
            }
            if(counter.get()<license.getValue()){
                counter.incrementAndGet();
                return true;
            }
            return false; 
        }

    }



    public enum License{
        LOW(10), MEDIUM(20) , HIGH(50);
        private int value; 
        private License(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }  
    }
}


