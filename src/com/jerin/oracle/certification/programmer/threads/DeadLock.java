package com.jerin.oracle.certification.programmer.threads;

public class DeadLock {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			try {
				A.accessAThenB();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Jerin");
		Thread t2 = new Thread(() -> {
			try {
				B.accessBThenA();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Staphy");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Completed");
	}
	
}

class A{
	public synchronized static void accessAThenB() throws InterruptedException {
//		synchronized (A.class) {
			System.out.println("Inside A " + Thread.currentThread().getName());
//			Thread.sleep(1000);
			
			B.accessBThenA();
			
//		}
	}
	
}
class B{
	public synchronized static void accessBThenA() throws InterruptedException {
//		synchronized (B.class) {
			System.out.println("Inside B " + Thread.currentThread().getName());
//			Thread.sleep(1000);
			A.accessAThenB();
//		}
	}
}
