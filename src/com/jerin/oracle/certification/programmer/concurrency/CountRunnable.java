package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountRunnable implements Runnable {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		es.submit(new CountRunnable(20, "A"));
		es.submit(new CountRunnable(20, "B"));
		es.submit(new CountRunnable(20, "C"));
		es.shutdown();
	}
	

	private int count;
	private String name;

	public CountRunnable(int count, String name) {
		this.count = count;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println(name + "  : " + i);
		}
	}

}
