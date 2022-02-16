package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
	private ReentrantLock l1 = new ReentrantLock();
	private ReentrantLock l2 = new ReentrantLock();
	
	private void lock12(){
		l1.lock();	
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		l2.lock();
		
		
		l1.unlock();
		l2.unlock();
		
		
	}

	

	private void lock21()  {
		l2.lock();
		
	
		l1.lock();
		l2.unlock();
		l1.unlock();
		
	}
	
	public static void main(String[] args) {
		DeadLock obj = new DeadLock();
		new Thread( () -> obj.lock12()).start();
		new Thread( () -> obj.lock21()).start();
	}
}
