package com.uday.dst.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBQ {
	
	static class ProducerConsumer implements Runnable{
		
		BlockingQueue<Integer> sharedQ;
		
		boolean isProducer; 
		
		String name;

		public ProducerConsumer(String name, boolean isProducer, 
				BlockingQueue<Integer> sharedQ){
			this.isProducer = isProducer; 
			this.sharedQ = sharedQ;
			this.name = name; 
		}
		
		public void produce() throws InterruptedException{
			for(int i = 0; i<10; i++){
				sharedQ.put(i);
				System.out.println(i+" Added by " + name);
			}
		}
		
		public void consume() throws InterruptedException{
			System.out.println(sharedQ.take() + " Taken by " + name);
		}

		@Override
		public void run() {
			try {
				
				if(this.isProducer){
					Thread.sleep(2000);
					produce();
				}
				else{
					Thread.sleep(4000);
					consume();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	public static void main(String[] args){
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(2);
		ProducerConsumer p1 = new ProducerConsumer("P1",true,bq);
		ProducerConsumer p2 = new ProducerConsumer("P2",true,bq);
		ProducerConsumer c1 = new ProducerConsumer("C1",false,bq);
		ProducerConsumer c2 = new ProducerConsumer("C2",false,bq);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(bq.size());
	}

}
