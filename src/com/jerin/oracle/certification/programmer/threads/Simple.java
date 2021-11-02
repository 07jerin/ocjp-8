package com.jerin.oracle.certification.programmer.threads;

import java.util.concurrent.Callable;

public class Simple {

	public static void main(String[] args) throws InterruptedException {
		extendThreadClass();

		threadConstructors();

		sleepAndJoin();

	}

	private static void sleepAndJoin() throws InterruptedException {
		Runnable r = () -> {
			System.out.println("Before sleep " + Thread.currentThread().getName());
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After sleep " + Thread.currentThread().getName());
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();

//		t1.join();
		System.out.println("Main Thread Before sleep");
		Thread.sleep(5 * 1000);
		System.out.println("Main Thread awakes");
	}

	private static void threadConstructors() {
		Runnable r = () -> System.out.println("Runnable, Thread name : " + Thread.currentThread().getName());
		Thread t1 = new Thread();
		t1.start();

		Thread t2 = new Thread("Named T2");
		t2.start();
		// First 2 threads have no run implementation and hence nothing is printed

		Thread t3 = new Thread(r, "Named T3");
		t3.start();

		Thread t4 = new Thread(r);
		t4.start();

		System.out.println("Completed");

//		t4.run(); // These 2 are invoked in main as we are  calling run directly
//		t4.run();
//		t4.start(); // error
	}

	private static void extendThreadClass() {
		Thread t = new Thread() {
			public void run() {
				System.out.println("In simple thread");
			}
		};

		t.start();
		System.out.println("Here");
	}

}
