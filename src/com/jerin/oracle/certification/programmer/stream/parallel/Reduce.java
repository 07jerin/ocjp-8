package com.jerin.oracle.certification.programmer.stream.parallel;

import java.util.stream.IntStream;

import com.jerin.oracle.certification.programmer.stream.Employee;

public class Reduce {

	public static void main(String[] args) {
//		calculateAges();
		calculateSum();
	}

	private static void calculateAges() {
		int ageSum = Employee.getEmployees()
				.parallelStream()
				.filter(e -> e.getAge() <= 30)
				.mapToInt(e -> e.getAge())
				.peek(System.out::println)
				.reduce(0, ((sum, age) -> sum + age));
		System.out.println(ageSum);
	}

	private static void calculateSum() {
		int sum = IntStream.rangeClosed(0, 15).sum();
		int sum2 = IntStream.rangeClosed(0, 10)
				.parallel()
				.reduce(0, ((a, b) -> a + b)); // 55

		System.out.println(sum2);
		
		
		// Following are not applicable of stream is parallel
		int sum3 = IntStream.rangeClosed(0, 10)
				.sequential()
				.reduce(5, ((a, b) -> a + b)); // 5 -> will be the intial value so 60
		
		System.out.println(sum3);
		
		int sum4 = IntStream.rangeClosed(0, 10)
				.sequential()
				.reduce(5, ((a, b) -> a + 10)); // 115
		//a --> Accumulator becomes accumulator + 10, 11 times and we have initial value 5
		// 11 * 10 + 5 = 115
		
		System.out.println(sum4);
		
		int sum5 = IntStream.rangeClosed(0, 10)
				.sequential()
				.reduce(5, ((a, b) -> 10 + b)); // 20
		//a --> Accumulator is not considered so computed results are discarded and hence final result will be 
		//		last element of stream (10) + hard coded 10 ==> 20
		
		System.out.println(sum5);
	}

}
