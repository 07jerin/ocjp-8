package com.jerin.oracle.certification.programmer.stream;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Primitive {
	public static void main(String[] args) {

		List<Employee> el = Employee.getEmployees();
		double sum = el.stream().mapToDouble(e -> e.getAge()).sum();

		System.out.println(sum);

//		el.clear();
		OptionalDouble avg = el.stream().mapToDouble(e -> e.getAge()).average();
//		System.out.println(avg.getAsDouble());
//		Might throw error if el list is empty
		System.out.println(avg.orElse(0));
		
		
		Map<Integer, List<Employee>> emplMap = 	el.stream()
				.filter(e -> e.getAge() > 10)
				.peek(System.out :: println)
//				.mapToInt(e-> e.getAge())
//				.sum();
				.collect(Collectors.groupingBy(e -> e.getAge()));
		System.out.println(emplMap);
				
	}

}
