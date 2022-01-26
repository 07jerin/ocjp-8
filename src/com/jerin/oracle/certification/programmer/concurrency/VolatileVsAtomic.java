package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileVsAtomic {
	
	public static void main(String[] args) throws InterruptedException {
//		atomicIntegerTest();
		
		Tester t = new Tester();
		new Thread(() -> t.updateFlag()).start();
		new Thread(() -> t.print()).start();
		
		
	}

	private static void atomicIntegerTest() throws InterruptedException {
		Tester t = new Tester();
		
		Runnable r = () -> {
			for(int i=0; i< 10000; i++) {
				t.increment();
			}
		};
		
		Runnable r2 = () -> {
			for(int i=0; i< 10000; i++) {
				t.increment();
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(t.value1);
	}

}


class Tester{
	
//	Boolean flag = true;
	boolean flag = true;
	
	volatile int value = 0;
	AtomicInteger value1 = new AtomicInteger(0);
	
	public void increment() {
		value1.incrementAndGet();
	}
	
	
	public void updateFlag() {
		flag = false;
	}
	
	
	
	public void print() {
		
		while(flag) {
			System.out.println("Printing...");
		}
		
	}
	
}
