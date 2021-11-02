package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoin {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		long start = System.nanoTime();
		int data[] = createData();
		System.out.println("Data creation paralell time : " + (System.nanoTime() - start));
		
		start = System.nanoTime();
		for (int i = 0; i < data.length; i++) {
			data[i] = ThreadLocalRandom.current().nextInt();
		}
		System.out.println("Data creation serial :         " + (System.nanoTime() - start));
		
		
		
		start = System.nanoTime();
		int min = findMinForkJoin(data);
		System.out.println("Min value = " + min + " || Time paralell : " + (System.nanoTime() - start));

		start = System.nanoTime();
		min = findMinSerial(data);
		System.out.println("Min value = " + min + " || Time serial : " + (System.nanoTime() - start));
	}
	
	private static int[] createData() {
		int[] data = new int[1000000000];
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(new RandomArray(data, 0, data.length));
		return data;
	}

	private static int findMinSerial(int[] data) {
		int min = Integer.MAX_VALUE;
		for (int val : data) {
			min = Math.min(val, min);
		}
		return min;
	}

	private static int findMinForkJoin(int[] data) throws InterruptedException, ExecutionException {

		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> task = new FindMinTask(data, 0, data.length);
		return pool.invoke(task);
	}

}

class RandomArray extends RecursiveAction{
	
	int[] data;
	final int threshold = 10000000;
	int start;
	int end;
	
	public RandomArray(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void compute() {
		if ((start + threshold) >= end) {
			int i = start;
			while (i < end) {
				data[i] = ThreadLocalRandom.current().nextInt();
			}
		}

		int mid = (end + start) / 2;
		ForkJoinTask<Void> t1 = new RandomArray(data, start, mid);
		ForkJoinTask<Void> t2 = new RandomArray(data, mid + 1, end);

		invokeAll(t1, t2);
		
	}
}

class FindMinTask extends RecursiveTask<Integer> {

	int[] data;
	final int threshold = 10000000;
	int start;
	int end;

	public FindMinTask(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer compute() {
		if ((start + threshold) >= end) {
			int min = Integer.MAX_VALUE;
			int i = start;
			while (i < end) {
				min = Math.min(data[i], min);
				i++;
			}
			return min;
		}

		int mid = (end + start) / 2;
		ForkJoinTask<Integer> t1 = new FindMinTask(data, start, mid);
		FindMinTask t2 = new FindMinTask(data, mid + 1, end);

		t1.fork();
		

		return Math.min(t2.compute(), t1.join());

	}
}
