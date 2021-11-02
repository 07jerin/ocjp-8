package com.jerin.oracle.certification.programmer.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SortCollectJoinGroup {

	public static void main(String[] args) {
		sort();
		collect();
		join();
		group();
	}
	
	private static void sort() {
		System.out.printf("\n +++++++++++++++++++++ Sort ++++++++++++++++++ \n");
		
		Consumer<Employee> printer = e -> System.out.printf("%8s Age: %2d RollNo: %d \n", e.getName(), e.getAge(), e.getRollNo()  );
		List<Employee> el = Employee.getEmployees();
		
		System.out.println("\n---------------- Sorted By Age ---------------");
		el.stream()
			.sorted(Comparator.comparing(Employee :: getAge))
			.forEach(printer);
		
		
		System.out.println("\n---------------- Sorted By Age reversed, then name ---------------");
		el.stream()
//			.sorted(Comparator.comparing(Employee :: getName))
			.sorted(Comparator.comparing(Employee :: getAge).reversed())
			// Note the last one added will be applied as sort order one, to
			// avoid this we can chain using then comparing
			.forEach(printer);
		
		
		System.out.println("\n---------------- Sorted By Age , then name using then comparing---------------");
		el.stream()
			.sorted(Comparator.comparing(Employee :: getAge)
					.thenComparing(Employee :: getName))
			.forEach(printer);
			
		
	}
	
	private static void collect() {
		System.out.printf("\n +++++++++++++++++++++ Collect ++++++++++++++++++ \n");
		
		List<Integer> vals = new ArrayList<>();
		vals.add(1);
		vals.add(1);
		vals.add(3);
		vals.add(2);
		vals.add(4);
		
		List<Integer> sortedValsLessThan4 = vals.stream()
			.filter(v -> v <4)
			.sorted(Comparator.comparing(Integer :: intValue))
			.collect(Collectors.toList());
		
		System.out.println( " sortedValsLessThan4 : " + sortedValsLessThan4);
		
		Set<Integer> uniqueValsLessThan4 = vals.stream()
				.filter(v -> v <4)
				.collect(Collectors.toSet());
		System.out.println( " uniqueValsLessThan4 : " + uniqueValsLessThan4);
		
		
	}
	
	private static void join() {
		System.out.printf("\n\n +++++++++++++++++++++ Join ++++++++++++++++++ \n");
		
		String sortedNamesabove30 = 
				Employee.getEmployees()
					.stream()
					.filter(e -> e.getAge() >30)
					.map(Employee :: getName)
					.sorted()
					.collect(Collectors.joining(" ,"));
		System.out.println(" sortedNamesabove30 : " + sortedNamesabove30);
	}
	
	
	private static void group() {
		System.out.printf("\n\n +++++++++++++++++++++ Group ++++++++++++++++++ \n");
		System.out.println("Grouped By Age , and Names joined in ,");
		
		Map<Integer, List<Employee>> ageMap = 
				Employee.getEmployees()
					.stream()
					.collect(Collectors.groupingBy(Employee :: getAge));
		
		ageMap.forEach((age, el) -> 
		System.out.println(age + " : " + 
				el.stream()
					.map(e -> e.getName()).sorted().collect(Collectors.joining(" , "))

		));	
	}

}
