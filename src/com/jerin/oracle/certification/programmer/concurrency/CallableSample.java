package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class CallableSample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		AtomicLong value1 = new AtomicLong(0);
		final long[] value2 = {0};
		IntStream.iterate(1, i -> 1).limit(100).parallel()
		    .forEach(i -> value1.incrementAndGet());
		IntStream.iterate(1, i -> 1).limit(100).parallel()
			    .forEach(i -> ++value2[0]);
		System.out.println(value1+" "+value2[0]);
	}
	
	public static void atomicOperationAndSych() throws InterruptedException, ExecutionException {
		ExecutorService exe = Executors.newCachedThreadPool();
		CounterCallable cal =  new CounterCallable(50000);
		Future<Integer> counter1 =  exe.submit(cal);
		Future<Integer> counter2 =  exe.submit(cal);
		Future<Integer> counter3 =  exe.submit(cal);
		Future<Integer> counter4 =  exe.submit(cal);
		Future<Integer> counter5 =  exe.submit(cal);
		Future<Integer> counter6 =  exe.submit(cal);
		
		System.out.println(counter1.get());
		System.out.println(counter2.get());
		System.out.println(counter3.get());
		System.out.println(counter4.get());
		System.out.println(counter5.get());
		System.out.println(counter6.get());
		
	}
	
	public static void execute1() {
		ExecutorService exe = Executors.newCachedThreadPool();
		Future<String> fut100 = exe.submit(new PrinterCallable<Integer>(100, 10));
		Future<String> futStaphy =  exe.submit(new PrinterCallable<String>("Staphy", 10));
		
		
		
		try {
			String fut00Result = fut100.get();
			String futStaphyRes = futStaphy.get();
			
			System.out.println(fut00Result);
			System.out.println(futStaphyRes);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class CounterCallable implements Callable<Integer>{
	
	private int count;
	private AtomicInteger atomicCount = new AtomicInteger(0);
	private int syncedCount;
	private AtomicInteger times;
	
	public CounterCallable(int times) {
		this.times = new AtomicInteger(times);
	}
	
	public Integer call() {
		while(times.get() > 0) {
			times.decrementAndGet();
			atomicCount.addAndGet(times.get());
			
//			System.out.println(Thread.currentThread().getName() + "  atomicCount :" + atomicCount ++);
//			System.out.println(Thread.currentThread().getName() + "  count :" + count ++);
			
			
//			synchronized(this) {
				
//				System.out.println(Thread.currentThread().getName() + " syncedCount :" + syncedCount ++);
//				System.out.println();
//			}
		
			
		}
		
		return atomicCount.get();
	}
}

class PrinterCallable<T> implements Callable<String> {

	private T value;
	private int times;


	PrinterCallable(T value, int times) {
		this.value = value;
		this.times = times;

	}

	@Override
	public String call() throws Exception {
		String sum = "";
		for (int i = 0; i < times; i++) {
			System.out.println(value);
			sum += value;
		}

		return sum;
	}
}
