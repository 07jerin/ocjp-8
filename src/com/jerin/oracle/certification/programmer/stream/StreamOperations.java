package com.jerin.oracle.certification.programmer.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;

public class StreamOperations {
	static List<Reading> readings = Arrays.asList(
			new Reading(1990, 45),
			new Reading(1991, 46),
			new Reading(1992, 47),
			new Reading(1993, 44),
			new Reading(1994, 45),
			new Reading(1995, 46),
			new Reading(1996, 50)
			);
	
	static ToDoubleFunction<Reading> getReading = r -> r.reading;

	public static void main(String[] args) {
		squareGreaterThan20();
		averageOptionalDouble();
		
		System.out.println();
		double sum = readings.stream().mapToDouble(getReading).sum();
		System.out.println(sum);
		
		OptionalDouble opSum = readings.stream()
			.mapToDouble(r -> r.reading)
			.reduce((v1, v2 ) -> v1+ v2);
		
		System.out.println(opSum.getAsDouble());
		
		double opSumWithIdentity = readings.stream()
				.mapToDouble(r -> r.reading)
//				.filter(r -> r ==0)
				.reduce(0, (v1, v2) -> v1 + v2);
		System.out.println(opSumWithIdentity);
		
		System.out.println("Reduce avg");
//		double opSumWithIdentity = readings.stream()
//				.mapToDouble(r -> r.reading)
//				.reduce(0, (v1, v2))

		
		System.out.print("Reduce min ");

		double min = readings.stream()
			.mapToDouble(r -> r.reading)
			.reduce(Double.MAX_VALUE , (v1, v2) -> Math.min(v1, v2));
		System.out.println(min);
		
	}

	private static void averageOptionalDouble() {
		System.out.println();
		
		OptionalDouble avg =  readings.stream()
			.mapToDouble(r -> r.reading)
//			.map(r -> r.reading)
			.filter(v -> v > 45).filter(v -> v < 48)
//			.mapToDouble(i -> i)
			.average();
		
		if(avg.isPresent()) {
			
			System.out.println("Average " + avg.getAsDouble());
		}else {
			System.out.println("Average empty"  );
		}
		
//		avg.ifPresentOrElse(a -> System.out.println("Average : " + a),
//					() -> System.out.println("Not present"));
		 
		
		 OptionalInt max = Arrays.stream(new int[] {1,2,3}).max();
		 
//		 max.ifPresentOrElse(System.out :: println, () -> System.out.println("Not presrent"));
	}

	private static void squareGreaterThan20() {
		List<Integer> vals = Arrays.asList(1, 2, 3, 4, 5, 6);
		long sqreGT20 = vals.stream()
				.map(i -> i * i)
				.filter(i -> i > 20)
				.peek(i -> System.out.println("GT20 sqre " + i))
				.count();
		System.out.println("Square GT 20 : " + sqreGT20);
	}
	

}

class Reading{
	int year;
	double reading;
	
	Reading(int year, double reading){
		this.year =  year;
		this.reading = reading;
	}
}
