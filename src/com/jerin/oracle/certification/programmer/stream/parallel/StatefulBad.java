package com.jerin.oracle.certification.programmer.stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jerin.oracle.certification.common.PrintUtil;
import com.jerin.oracle.certification.programmer.stream.Employee;

public class StatefulBad {
	
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<Employee> el = Employee.getEmployees();
		
		PrintUtil.spacer("Serial Collected ");
		l1= el.stream().map(e -> e.getName())
				.peek(e -> System.out.println("Thread Collected " + Thread.currentThread().getId()))
				.collect(Collectors.toList());
		System.out.println("Serial Collected " + l1);
		
		PrintUtil.spacer("Parallel Collected ");
		l1= new ArrayList<String>();
		l1= el.parallelStream().map(e -> e.getName())
				.peek(e -> System.out.println("Thread Collected " + Thread.currentThread().getId()))
				.collect(Collectors.toList());
		System.out.println("Parallel Collected " + l1);
		
		PrintUtil.spacer("Serial Stateful Collected ");
		final List<String> l2= new ArrayList<String>();
		el.stream().map(e -> e.getName())
			.peek(e -> System.out.println("Thread Collected " + Thread.currentThread().getId()))
			.forEach(e -> l2.add(e));
		System.out.println("  Serial Stateful Collected " + l2);
		
		PrintUtil.spacer("Parallel Stateful Collected ");
		List<String> l3= new ArrayList<String>();
		el.parallelStream().map(e -> e.getName())
			.peek(e -> System.out.println("Thread Collected " + Thread.currentThread().getId()))
			.forEach(e -> l3.add(e));
		System.out.println("Parallel Stateful Collected " + l3);
		
//		l3 = new ArrayList<String>();	
	}

}
