package com.jerin.oracle.certification.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.jerin.oracle.certification.associate.Sample;
import com.jerin.oracle.certification.programmer.stream.Employee;

public class Basics extends Sample {

	public static void main(String[] args) {

		treeSetTry();

		autoBoxing();

		sort();

		binarySearch();
		
		
		new Basics().testInheritance();
		
	}

	private static void binarySearch() {
		
		
		List<String> sl = Arrays.asList("D", "A", "B", "Z");
		Collections.sort(sl);
		System.out.println("B  : " + Collections.binarySearch(sl, "B"));
		System.out.println("C : " + Collections.binarySearch(sl, "C"));

		Collections.sort(sl, Comparator.reverseOrder());
		System.out.println("After sorting in reverss and NOT passing comparator");
		System.out.println("B  : " + Collections.binarySearch(sl, "B"));
		System.out.println("C : " + Collections.binarySearch(sl, "C"));

		System.out.println("After sorting in reverss and  PASSING comparator");
		System.out.println("B  : " + Collections.binarySearch(sl, "B", Comparator.reverseOrder()));
		System.out.println("C : " + Collections.binarySearch(sl, "C", Comparator.reverseOrder()));
	}

	private static void sort() {
		// Comparator<T>
		List<Employee> el = Employee.getEmployees();
		// Collections.sort(el); CTE as Employee is not Comparable
		Collections.sort(el, (e1, e2) -> e1.getAge() - e2.getAge());
		System.out.println(el);
		// Arrays.sort();
	}

	private static void autoBoxing() {
		Integer x = 10;
		x++;
	}

	private static void treeSetTry() {
//		 TreeSet<Employee> ts = new TreeSet<Employee>(); Run time error as the Employee is not comparable
		TreeSet<Employee> ts = new TreeSet<Employee>((e1, e2) -> e1.getName().compareTo(e2.getName()));

		ts.add(new Employee("Jerin", 1, 30));
		ts.add(new Employee("Staphy", 1, 30));
		ts.add(new Employee("Aby", 1, 30));

		ts.stream().forEach(System.out::println);
	}
	
	private void testInheritance() {
		System.out.println();
		System.out.println(this.a);
//		new Sample().a 
	}

}

