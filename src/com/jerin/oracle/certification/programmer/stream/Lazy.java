package com.jerin.oracle.certification.programmer.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lazy {
	
	public static void main(String[] args) {
		Predicate<Integer> gt3 = i-> {
			System.out.println("In GT3 " + i);
			return i >3;
		};
		
		Predicate<Integer> gt2 = i-> {
			System.out.println("In GT2 " + i);
			return i >2;
		};
		
		Predicate<Integer> gt4 = i-> {
			System.out.println("In GT4 " + i);
			return i >4;
		};
		
		System.out.println("No terminal operation");
		Stream.of(1,2,3).filter(gt2).filter(gt3);
		
		System.out.println("With Terminal opertion");
		Stream.of(1,2,3,5)
			.filter(gt2)
			.filter(gt3)
			.filter(gt4)
			.count();
	}

}
