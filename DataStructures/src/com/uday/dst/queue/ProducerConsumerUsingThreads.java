package com.uday.dst.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerUsingThreads {
	
	static class Worker implements Runnable{
		
		Queue<Integer> q;
		
		String name;
		
		int capacity = 10;
		
		static int v = 1;
				
		// true - producer, false - consumer
		boolean isProducer;
		
		public Worker(String name, Queue<Integer> q, boolean isProducer){
			this.name = name;
			this.q = q;
			this.isProducer = isProducer;
		}
		
		public void produce() throws InterruptedException{
			
				while(q.size()==capacity){
					synchronized(q){
						q.wait();
					}
				}
				
				synchronized(q){
					q.add(v);
					System.out.println(this.name+" produced "+v +", size="+q.size());
					v++;
					q.notifyAll();
				}
				Thread.sleep(1000);
			
		}
		
		public void consume() throws InterruptedException{
			
				while(q.isEmpty()){
					synchronized(q){
						q.wait();
					}
				}
				synchronized(q){
					Integer a = q.poll();
					System.out.println(this.name+" consumed "+a);
					q.notifyAll();
				}
				Thread.sleep(3000);
			
		}

		@Override
		public void run() {
			
			while(true){
				if(this.isProducer){
					try {
						this.produce();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					try {
						this.consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args){
		Queue<Integer> q = new LinkedList<Integer>();
		Worker w1 = new Worker("P1", q, true);
		Worker w2 = new Worker("P2", q, true);
		Worker w3 = new Worker("P3", q, false);
		Worker w4 = new Worker("P4", q, false);
		Thread p1 = new Thread(w1);
		Thread p2 = new Thread(w2);
		Thread p3 = new Thread(w3);
		Thread p4 = new Thread(w4);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}

}
