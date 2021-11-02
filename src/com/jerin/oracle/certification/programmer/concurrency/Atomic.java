package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Atomic {
	
	public static void main(String[] args) throws InterruptedException {
		atomicIncrement();
		
	}

	private static void atomicIncrement() throws InterruptedException {
		Counter c = new Counter();
		Runnable r = () -> {
			for(int i=0; i< 5000; i++)
				c.increment();	
		};
		Thread t1 = new Thread(r); 
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(c.getState());
	}

}


class Counter{
	
	private volatile int vInt;
	private volatile Integer vInteger = 0;
	
	private int cInt;
	private Integer cInteger = 0;
	
	
	private AtomicInteger aInt = new AtomicInteger(0);
	
	private Lock lock = new ReentrantLock();
	
	public void increment() {
		
//		lock = new ReentrantLock();
		vInt++;
//		lock.lock();
		vInteger++;
//		lock.unlock();
		cInt++;
		cInteger++;
		aInt.incrementAndGet();
		
	}
	
	public String getState() {
		StringBuilder sb = new StringBuilder();
		sb.append(", vInt : " + vInt);
		sb.append(", vInteger : " + vInteger);
		sb.append(", cInt : " + cInt);
		sb.append(", cInteger : " + cInteger);
		sb.append(", aInt : " + aInt.get());
		return sb.toString();
	}
	
}