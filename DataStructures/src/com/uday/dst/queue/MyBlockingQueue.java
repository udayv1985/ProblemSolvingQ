package com.uday.dst.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<T> implements MyQueue<T> {
	
	private Queue<T> queue;
	
	private int maxElements;
	
	public MyBlockingQueue(int maxE){
		this.maxElements = maxE;
		queue = new LinkedList<T>();
	}

	@Override
	public synchronized void add(T t) throws InterruptedException {
		System.out.print("Adding...");
		while(queue.size()>=maxElements){
			this.wait();
		}
		queue.add(t);
		System.out.println("Added- "+t);
		this.notifyAll();
	}

	@Override
	public synchronized T poll() throws InterruptedException {
		System.out.print("Polling...");
		while(queue.size()==0){
			this.wait();
		}
		T t = queue.poll();
		System.out.println("Polled- "+t);
		this.notifyAll();
		return t;
	}
	
	public static void main(String[] args){
		MyQueue<Long> q = new MyBlockingQueue<>(2);
		
		Thread thread = new Thread("Thread 1") {
		      public void run(){
		        System.out.println("run by: " + getName());
		        try {
		        	sleep(2000);
					q.add(new Long(2));
					sleep(5000);
					q.poll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		 };
		 Thread thread2 = new Thread("Thread 2") {
		      public void run(){
		        System.out.println("run by: " + getName());
		        try {
		        	q.poll();
					q.add(new Long(1));
					q.add(3l);
					q.add(4l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		 };
		 thread.start();
		 thread2.start();
	}

}
