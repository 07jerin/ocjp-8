package com.jerin.oracle.certification.programmer.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Transactions {
	
	public static void main(String[] args) {
		List<Employee> el = Employee.getEmployees();
		
//		Count
		long count = el.stream()
					.filter(e -> e.getAge() > 10)
					.count();
		System.out.println("Age > 10 count " + count);
		
//		Max age
		System.out.println("Oldest ----------------");
		Optional<Employee> oldest = el.stream().max( Comparator.comparing(Employee :: getAge ));
		System.out.println(oldest.orElseGet( ()-> new Employee("", 0, 0)));
												
//		Min Age
		System.out.println("youngest ----------------");
		Optional<Employee> youngest = el.stream().min(Comparator.comparing(Employee :: getAge));
		if(youngest.isPresent()) {
			System.out.println(youngest.get());
		}
	}	

}
