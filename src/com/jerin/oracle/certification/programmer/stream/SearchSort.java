package com.jerin.oracle.certification.programmer.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.jerin.oracle.certification.common.PrintUtil;

public class SearchSort {

	public static void main(String[] args) {

		List<Employee> el = Employee.getEmployees();

		allAnyNoneMatch(el);

		findFirstFindAny(el);

		sortComparatoyDistinct(el);

	}

	private static void sortComparatoyDistinct(List<Employee> el) {
		PrintUtil.spacer("Sorting");
		
//		el.stream().sorted().forEach(System.out :: println);// Error as Employee is not comparable
		Arrays.stream(new int[] {1,6,3,5,4,2}).sorted().forEach(System.out :: print);
		System.out.println();
		Arrays.stream(new Integer[] {1,6,3,5,4,2}).sorted().forEach(System.out :: print);
		System.out.println();
		
		Comparator<Employee> byAge = (e1, e2) -> e1.getAge() - e2.getAge();
		el.stream().sorted(byAge).forEach(e -> System.out.print(" :: " + e));
		System.out.println();
		System.out.println("By Age reveresed");
		el.stream().sorted(byAge.reversed()).forEach(e -> System.out.print(" :: " + e));
		
		Comparator<Employee> byRollNumber = Comparator.comparing(Employee :: getRollNo);
		System.out.println();
		System.out.println("byRollNumber");
		el.stream().sorted(byRollNumber).forEach(e -> System.out.print(" :: " + e));
		
		System.out.println();
		Comparator<Employee> byName = Comparator.comparing(Employee :: getName);
//		Comparator<Employee> byAgeThenName = byAge.thenComparing((e1, e2) -> e1.getName().compareTo(e2.getName()));
//		Comparator<Employee> byAgeThenName = byAge.thenComparing(byName);
		System.out.println("byAgeThenName");
//		el.stream().sorted(byAgeThenName).forEach(e -> System.out.print(" :: " + e));
		el.stream().sorted(byAge.thenComparing(byName)).forEach(e -> System.out.print(" :: " + e));
		
		System.out.println();
		System.out.println("Distinct Ages Sorted");
		el.stream().mapToInt(e -> e.getAge()).distinct().sorted().forEach(a -> System.out.print("," + a));
	}

	private static void allAnyNoneMatch(List<Employee> el) {
		
		// FindFirst
		// Find Any
		// all Match
		// any Match
		// None Match
		
		
		boolean isAllMatch = el.stream().allMatch(e -> e.getAge() > 100);
		boolean isAnyMatch = el.stream().anyMatch(e -> e.getAge() > 100);
		boolean isNoneMatch = el.stream().noneMatch(e -> e.getAge() > 100);

		System.out.println(">100");
		System.out.println("isAllMatch " + isAllMatch);
		System.out.println("isAnyMatch " + isAnyMatch);
		System.out.println("isNoneMatch " + isNoneMatch);

		isAllMatch = el.stream().allMatch(e -> e.getAge() > 8);
		isAnyMatch = el.stream().anyMatch(e -> e.getAge() > 8);
		isNoneMatch = el.stream().noneMatch(e -> e.getAge() > 8);
		
		System.out.println(" > 8");
		System.out.println("isAllMatch " + isAllMatch);
		System.out.println("isAnyMatch " + isAnyMatch);
		System.out.println("isNoneMatch " + isNoneMatch);
		
		isAllMatch = el.stream().allMatch(e -> e.getAge() > 30);
		isAnyMatch = el.stream().anyMatch(e -> e.getAge() > 30);
		isNoneMatch = el.stream().noneMatch(e -> e.getAge() > 30);
		
		System.out.println(" > 30");
		System.out.println("isAllMatch " + isAllMatch);
		System.out.println("isAnyMatch " + isAnyMatch);
		System.out.println("isNoneMatch " + isNoneMatch);
		
		System.out.println();
		System.out.println("Short circuit any match > 45");
		el.stream()
			.peek(System.out::println)
			.anyMatch(e -> e.getAge() > 45);
		
		System.out.println("Short circuit all match > 45");
		el.stream()
		.peek(System.out::println)
		.allMatch(e -> e.getAge() > 45);
		
		System.out.println("Short circuit none match > 45");
		el.stream()
			.peek(System.out::println)
			.noneMatch(e -> e.getAge() > 45);
	}

	private static void findFirstFindAny(List<Employee> el) {
		
		System.out.println();
		
		Optional<Employee> ef = el.stream().filter(e -> e.getAge() > 40).findFirst();
		System.out.println("Find first " + ef.get());
		Optional<Employee> any = el.stream().filter(e -> e.getAge() > 40).findAny();
		System.out.println("Find any " + any.get());
		
		System.out.println("Short circuit find first > 45");
		el.stream()
			.peek(System.out::println)
			.filter(e -> e.getAge() > 45)
			.findFirst();
		
		System.out.println("Short circuit find find ANy > 45");
		el.stream()
			.peek(System.out::println)
			.filter(e -> e.getAge() > 45)
			.findAny();
	}

}
