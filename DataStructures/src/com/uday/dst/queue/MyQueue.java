package com.uday.dst.queue;

public interface MyQueue<T> {
	
	public void add(T t) throws InterruptedException;
	
	public T poll() throws InterruptedException;

}
