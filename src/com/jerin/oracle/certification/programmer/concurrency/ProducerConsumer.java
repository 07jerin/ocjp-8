package com.jerin.oracle.certification.programmer.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	private ReentrantLock lock = new ReentrantLock();
	private Condition produceCondition = lock.newCondition();
	private Condition consumeCondition = lock.newCondition();
	private Queue<Integer> q = new LinkedList<Integer>();
	private int maxsize = 5;

	private void produce() {

		lock.lock();

		try {
			while (q.size() == maxsize)
				produceCondition.await();
			int val = (int) (Math.random() * 100);
			q.add(val);
			System.out.println("adding by thread " + Thread	.currentThread()
															.getId()
					+ " : value :  " + val + " : " + q);
			consumeCondition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	private void consume() {

		lock.lock();
		try {
			while (q.size() == 0)
				consumeCondition.await();

			int removing = q.remove();
			System.out.println("removing " + " : " + removing + " by thread " + +Thread	.currentThread()
																						.getId());
			produceCondition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			lock.unlock();
		}

	}

	public static void main(String[] args) {
		ProducerConsumer p = new ProducerConsumer();
		ExecutorService pc = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {
			pc.submit(() -> {
				p.produce();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				p.consume();
			});
		}

		pc.shutdown();

	}

}
