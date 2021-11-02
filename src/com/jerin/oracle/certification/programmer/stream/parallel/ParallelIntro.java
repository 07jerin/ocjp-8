package com.jerin.oracle.certification.programmer.stream.parallel;

import java.util.stream.IntStream;

public class ParallelIntro {
	
	public static void main(String[] args) {
		System.out.println("Prallel");
		System.out.println(IntStream.rangeClosed(0, 100000000).parallel().sum());
		System.out.println("Seqeuntial");
		System.out.println(IntStream.rangeClosed(0, 100000000).sequential().sum());
		
		
		IntStream.rangeClosed(0, 10).parallel().peek( i-> System.out.println(Thread.currentThread().getName() + " : " + i)).sum();
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		
		IntStream.rangeClosed(0, 50)
			.limit(25)
//			.parallel()
			.filter(i -> i%2 == 0)
			.peek(i -> System.out.print(", " + i))
			.parallel()
			.forEachOrdered(i -> System.out.print(", O:" + i));
//			.forEach(i -> System.out.print(", O:" + i));
	}
	
	

}
