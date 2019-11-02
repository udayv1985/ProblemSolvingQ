package com.uday.multithread;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolToo {
	
	int size;
	
	Worker[] tArr; 
	
	LinkedBlockingQueue<Runnable> queue; 
	
	public MyThreadPoolToo(int size){
		this.size = size;
		queue = new LinkedBlockingQueue<>();
		tArr = new Worker[size];
		for(Worker t : tArr){
			t = new Worker();
			t.start();
		}
	}
	
	public void execute(Runnable task) throws InterruptedException{
		queue.put(task);
	}
	
	
	class Worker extends Thread{
		
		@Override
		public void run(){
			while(true){
				Runnable task = null;
				
				try {
					task = queue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("worker ex");
					e.printStackTrace();
				}
				task.run();
			}
		}
	}
	
	public static void main(String[] args){
		MyThreadPoolToo pool = new MyThreadPoolToo(2);
		Runnable r1 = pool.new Task("T1");
		Runnable r2 = pool.new Task("T2");
		Runnable r3 = pool.new Task("T3");
		try {
			pool.execute(r1);
			pool.execute(r2);
			pool.execute(r3);
			pool.execute(r2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class Task implements Runnable{
		
		String name;
		
		public Task(String s){
			name = s;
		}

		@Override
		public void run() {
			System.out.println("Executing task - "+name);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("main ex");
				e.printStackTrace();
			}
		}
		
	}

}
