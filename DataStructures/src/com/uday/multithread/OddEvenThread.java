package com.uday.multithreading;

public class OddEvenThread implements Runnable {
	
	private boolean isOdd;
	
	static final int count = 10;
	
	static int num = 1;
	
	static Object lock = new Object();
	
	private int remainder = 0;
	
	public OddEvenThread(boolean b){
		isOdd = b;
		if(isOdd){
			remainder = 1;
		}
	}
	
	@Override
	public void run() {
		while (num < count) {
			synchronized (lock) {
				while (num % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + num);
				num++;
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		OddEvenThread odd = new OddEvenThread(true);
		OddEvenThread even = new OddEvenThread(false);
		Thread t1 = new Thread(odd,"Odd");
		Thread t2 = new Thread(even,"Even");
		t1.start();
		t2.start();
		//t1.join();
		//t2.join();
	}

}
