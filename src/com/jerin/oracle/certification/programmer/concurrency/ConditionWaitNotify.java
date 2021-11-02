package com.jerin.oracle.certification.programmer.concurrency;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionWaitNotify {

	public static void main(String[] args) {

		Lock mainLock = new ReentrantLock();

		Condition kidPool = mainLock.newCondition();
		Condition geekPool = mainLock.newCondition();

		Shop s1 = new Shop(mainLock, mainLock, kidPool, geekPool);
		Shop s2 = new Shop(mainLock, mainLock, kidPool, geekPool);

		Thread t1 = new Thread(s1, "Shop 1");
		Thread t2 = new Thread(s2, "Shop 2");
		
		t1.start();
//		t2.start();
		
		Kid staphy = new Kid(mainLock, kidPool, s1);
		Kid jerin = new Kid(mainLock, kidPool, s1);
		Kid jeffin = new Kid(mainLock, kidPool, s1);
		
		Geek leo = new Geek(mainLock, geekPool, s1);
		Geek sheldon = new Geek(mainLock, geekPool, s1);
		Geek amy = new Geek(mainLock, geekPool, s1);
		
		Thread tstaphy = new Thread(staphy, "staphy");
		Thread tjerin = new Thread(jerin, "jerin");
		Thread tjeffin = new Thread(jeffin, "jeffin");
		Thread tleo = new Thread(leo, "leo");
		Thread tsheldon = new Thread(sheldon, "sheldon");
		Thread tamy = new Thread(amy, "amy");

		
		tstaphy.start();
		tjerin.start();
//		tjeffin.start();
		tleo.start();
//		tsheldon.start();
//		tamy.start();
	}

}

class Kid implements Runnable {

	Lock lock;
	Condition kidPool;
	Shop s;

	public Kid(Lock lock, Condition kidPool, Shop s) {
		this.lock = lock;
		this.kidPool = kidPool;
		this.s = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Trying to run");
		this.lock.lock();
		System.out.println(Thread.currentThread().getName() + " recieved locks");
		int books = s.getBooks();
		System.out.println(Thread.currentThread().getName() + " Recieved " + books);
		while (books > 0) {
			try {
				Thread.sleep(1000);
				this.kidPool.await();
				books = s.getBooks();
				System.out.println(Thread.currentThread().getName() + " Recieved after waiting " + books);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
			
		}
		this.lock.unlock();
		
	}

}

class Geek implements Runnable {
	Lock lock;
	Condition geekPool;
	int booksAcquired = 0;
	Shop s;

	public Geek(Lock lock, Condition geekPool, Shop s) {
		this.lock = lock;
		this.geekPool = geekPool;
		this.s = s;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " Trying to run");
		this.lock.lock();
		System.out.println(Thread.currentThread().getName() + " recieved locks");
		int books = s.getBooks();
		System.out.println(Thread.currentThread().getName() + " Recieved " + books);
		while (books > 0) {
			try {
				Thread.sleep(1000);
				this.geekPool.await();
				books = s.getBooks();
				System.out.println(Thread.currentThread().getName() + " Recieved after waiting " + books);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
			
		}
		this.lock.unlock();
		
	}
}

class Shop implements Runnable {

	Lock kidsLock;
	Lock geeksLock;
	Integer numberOfBooks = 10;
	Condition kidPool;
	Condition geekPool;
	AtomicInteger counter = new AtomicInteger(5);

	public Shop(Lock kidsLock, Lock geeksLock, Condition kidPool, Condition geekPool) {
		this.geeksLock = geeksLock;
		this.kidsLock = kidsLock;
		this.kidPool = kidPool;
		this.geekPool = geekPool;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Trying to run");
		while (counter.decrementAndGet() > 0) {
			System.out.println(Thread.currentThread().getName() + " Going to add books for times:  " + counter.get());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addBooksAndNotify();
		}
		finalNotify();
		
	}
	
	public void finalNotify() {
		System.out.println("Final notification");
		kidsLock.lock();
		geeksLock.lock();
		numberOfBooks = 0;
		kidPool.signalAll();
		geekPool.signalAll();
		
	}

	public void addBooksAndNotify() {
		System.out.println(Thread.currentThread().getName() + " going to add books and notify");
		kidsLock.lock();
		geeksLock.lock();

		System.out.println(Thread.currentThread().getName() + " recieved locks");
		try {
			int books = (int)Math.random()*100;
			numberOfBooks = numberOfBooks + books;

			System.out.println("Adding " + books + " by " + Thread.currentThread().getName() + ", Total books are : "
					+ numberOfBooks);

			kidPool.signalAll();
			geekPool.signalAll();
		} finally {
			kidsLock.unlock();
			geeksLock.unlock();
		}

	}

	public int getBooks() {
		kidsLock.lock();
		geeksLock.lock();
		int count = 0;
		try {
			count = ((int)Math.random()*100 / 5 ) + 1;
			if (numberOfBooks - count >= 0) {
				numberOfBooks = numberOfBooks - count;
				return count;
			}
			return 0;
		} finally {
			kidsLock.unlock();
			geeksLock.unlock();
		}

	}

}
