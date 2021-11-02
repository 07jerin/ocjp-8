package com.jerin.oracle.certification.programmer.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.jerin.oracle.certification.common.PrintUtil;

public class MapAndPeekLazy {

	
	
	public static void main(String[] args) {
		List<Employee> em = new ArrayList<Employee>();
		Supplier<Employee> em1 = () -> new Employee("Jerin", 1, 32);
		Supplier<Employee> em2 = () -> new Employee("Staphy", 2, 30);
		Supplier<Employee> em3 = () -> new Employee("Jaisy", 3, 37);
		Supplier<Employee> em4 = () -> new Employee("Jeffin", 4, 27);
		
		Consumer<Employee> peekFunc = e -> System.out.println("Peek Function === : " +e);
		
		em.add(em1.get());
		em.add(em2.get());
		em.add(em3.get());
		em.add(em4.get());
		em.add(new Employee("Joseph", 5 , 65));
		em.add(new Employee("Ruben", 6 , 9));
		
		em.stream()
		.peek(peekFunc)
		.filter(e -> e.getAge() > 30)
		.peek(e -> System.out.println("Age > 30 " + e))
		.filter(e -> e.getRollNo() > 2)
		.peek(e -> System.out.println("Roll no > 2 " + e))
		.map(e -> e.getAge())
		.forEach(e -> System.out.println(e));
		
		
		System.out.println( " ------------------- Find First -------------------");
		
		Optional<String> firstName = em.stream()
		.peek(peekFunc)
		.filter(e -> e.getAge() > 30)
		.peek(e -> System.out.println("Age > 30 " + e))
		.filter(e -> e.getRollNo() > 2)
		.peek(e -> System.out.println("Roll no > 2 " + e))
		.map(e -> e.getName())
		.findFirst(); // Stop at the first occurence
		
		Supplier<String> defaultName = () -> "No Name";
		System.out.println(firstName.orElseGet(defaultName));
//		System.out.println(firstName.get()); this will throw NPE if value is not present 
		
		
		PrintUtil.spacer("INtersting peek");
		Employee.getEmployees().stream()
//		.parallel()
		.peek(e -> System.out.println())
		.peek(e -> System.out.println("Peek B4 Filter " + e))
		.filter(e -> e.getAge() > 30)
		.peek(e -> System.out.println("Peek After Age Filter " + e))
		.filter(e -> e.getName().length() > 4)
		.peek(e -> System.out.println("Peek After Name Filter " + e))
//		.peek(e -> System.out.println("No terminal"));
//		.findFirst();
//		.findAny();
		.collect(Collectors.toList());
	}
}
