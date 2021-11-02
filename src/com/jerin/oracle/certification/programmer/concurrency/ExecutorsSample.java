package com.jerin.oracle.certification.programmer.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsSample {

	public static void main(String[] args) throws InterruptedException {
		
		differentTypes();
		
		callableAndFutureWithShutDown();
	
	}

	private static void callableAndFutureWithShutDown() throws InterruptedException {
		Callable<Integer> numGen = () ->{
			System.out.println("Generating in " + Thread.currentThread().getName());
			return (int)(new Random().nextDouble() * 1000);
		};
		
		Runnable r = () -> System.out.println("s");
		
		Integer value = 0;
		try {
			value = numGen.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		Thread.sleep(1000);
		es.execute(r);
		Future<Integer> result = es.submit(numGen);
//		es.shutdown();
		System.out.println("After submit");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " printing " + result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		es.shutdown();
//		System.out.println(Thread.currentThread().getName() + " printing " + es.submit(numGen));
//		System.out.println(Thread.currentThread().getName() + " printing " + es.submit(numGen));
//		es.shutdown();
	}

	private static void differentTypes() {
		ExecutorService esc = Executors.newCachedThreadPool();
		ExecutorService esf = Executors.newFixedThreadPool(4);
		ExecutorService ess = Executors.newSingleThreadExecutor();
	}

}
