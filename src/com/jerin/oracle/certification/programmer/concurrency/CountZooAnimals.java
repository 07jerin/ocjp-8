package com.jerin.oracle.certification.programmer.concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class CountZooAnimals {
	static int counter = 0;
	public static Integer performCount(int exhibitNumber) {
		return exhibitNumber;
	}

	public static void printResults(Future<?> f) {
		try {
			System.out.println(f.get()); // o1
		} catch (Exception e) {
			System.out.println("Exception!");
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		final List<Future<?>> results = new ArrayList<>();
		IntStream.range(0, 10).forEach(i -> results.add(service.submit(() -> performCount(i)))); // o2
		results.stream().forEach(f -> printResults(f));
		service.shutdown();
		
		t3();
	}
	
	
	
	   public static void t3() throws InterruptedException, ExecutionException {
		  
	      ExecutorService service = Executors.newSingleThreadExecutor();
	      List<Future<?>> results = new ArrayList<>();
	      IntStream.iterate(0,i -> i+1).limit(5).forEach(
	            i -> results.add(service.submit(() -> ++counter)) // n1
	      );
	      for(Future<?> result : results) {
	         System.out.print(result.get()+" "); // n2
	      }
	      service.shutdown();
	   }
}