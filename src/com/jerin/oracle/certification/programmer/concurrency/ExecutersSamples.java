package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutersSamples {
	
	private static Callable<Void> c = () -> {
		try {
			long id = Thread	.currentThread().getId();
			if(id % 2 == 0) {
				System.out.print(id + " Exception - ");
				throw new RuntimeException("Test exception");
			}
			System.out.print(id + " - ");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	
	private static Runnable r = () -> {
		try {
			long id = Thread	.currentThread().getId();
			if(id % 2 == 0) {
				throw new RuntimeException("Test exception");
			}
			System.out.print(id + " - ");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	public static void main(String[] args) {
//		new ExecutersSamples().paralellExecution();

//		print10Times(Executors.newFixedThreadPool(10));
//		print10Times(Executors.newCachedThreadPool());
//		
		
		
//		ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(10);
//		scheduledService.schedule(r, 2, TimeUnit.SECONDS);
//		scheduledService.scheduleAtFixedRate(r, 1, 2, TimeUnit.SECONDS);
//		scheduledService.scheduleWithFixedDelay(r, 1, 2, TimeUnit.SECONDS);
		
		
		
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		print10Times(singleThreadExecutor);
	}

	private static void print10Times(ExecutorService es) {
		System.out.println("-----------------------");
		for (int i = 0; i < 5; i++) {
			es.submit(c);
		}
		es.shutdown();

	}

	private void paralellExecution() {
		int coreCount = Runtime	.getRuntime()
								.availableProcessors();

		System.out.println(coreCount);

	}

}
