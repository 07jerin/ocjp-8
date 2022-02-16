package com.jerin.oracle.certification.programmer.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneratingStreams {
	
	public static void main(String[] args) {
//		Stream.iterate(0, i -> i + 1).forEach(System.out::println); // Infinite stream
		Stream.iterate(0, i -> i + 5)
		.limit(4)
		.forEach(System.out::println); 
		
		System.out.println();
		Stream.iterate(0, i -> i+5)
		.filter(i -> i%10 ==0 )
		.skip(5)
		.limit(5)
		.forEach(System.out::println);
		
		System.out.println();
		Stream.iterate(0, i -> i+5)
		.filter(i -> i%10 ==0 )
		.skip(5)
		.limit(5)
		.findFirst().ifPresent(System.out::println);
		
		System.out.println();
		IntStream.range(0, 2).forEach(System.out::println);
		
		System.out.println();
		IntStream.rangeClosed(0, 2).forEach(System.out::println);
		
		System.out.println();
		Stream.generate(() -> new Random().nextInt())
		.skip(2)
		.limit(5)
		.filter(i -> i % 7 == 0)
		.findAny().ifPresent(null);
		
		Optional.ofNullable(null).ifPresent(s -> System.out.println(" present"));
		
		
		Stream<Integer> is = Stream.of(1,2,3);
		IntStream iss = Arrays.stream(new int []{1,2,3});
	}

}

