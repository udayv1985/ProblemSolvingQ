package com.uday.dst.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.uday.dst.queue.MyDelayQueue.DelayedObj;

public class MyDelayQueue<T extends DelayedObj> implements MyQueue<T> {
	
	private Queue<T> queue;
	
	public long delayInMillisecs;
	
	public MyDelayQueue(long d){
		this.delayInMillisecs = d;
		queue = new LinkedList<T>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized void add(T t) throws InterruptedException {
		queue.add((T) t.setInitTime());
	}

	@Override
	public synchronized T poll() throws InterruptedException {
		if(!queue.isEmpty()){
			while(!queue.peek().isExpired(this.delayInMillisecs)){
				//this.wait(500);
			}
			this.notifyAll();
			return queue.poll();
		}
		return null;
	}
	
	static class Message implements DelayedObj{
		Integer data;
		
		long initTime;
		
		public Message(int d){
			data = d;
		}
		
		public long getInitTime(){
			return this.initTime;
		}

		@Override
		public DelayedObj setInitTime(){
			this.initTime = System.currentTimeMillis();
			return this;
		}

		@Override
		public boolean isExpired(long ttl) {
			return ((System.currentTimeMillis() - this.initTime)>=ttl);
		}
		
		
	}
	
	public interface DelayedObj{
		public DelayedObj setInitTime();
		
		public boolean isExpired(long ttl);
	}
	
	public static void main(String[] args){
		MyQueue<Message> dq = new MyDelayQueue<>(4000l);
		try {
			dq.add(new Message(4));
			System.out.println(dq.poll().data);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
