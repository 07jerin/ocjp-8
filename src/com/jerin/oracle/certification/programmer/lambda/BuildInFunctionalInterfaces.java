package com.jerin.oracle.certification.programmer.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.jerin.oracle.certification.programmer.stream.Employee;

public class BuildInFunctionalInterfaces {

	
	// Supplier
	// Consumer
	// Functional
	// Bi-Predicate
	
	
	static Supplier<Employee> sup1 = () -> new Employee("Jerin", 100, 32);
	static Supplier<Employee> sup2 = () -> new Employee("Staphy", 100, 29);
	static Supplier<Employee> sup3 = () -> new Employee("Jeffin", 100, 27);
	static Supplier<Employee> sup4 = () -> new Employee("Jaisy", 100, 37);
	
	static Consumer<Employee> printer = e -> System.out.println(e);
	
	static Function<Employee, String> upperCaseName = e -> e.getName().toUpperCase();
	
	static Predicate<Employee> pre = e -> e.getAge() > 30;
	
	static BiPredicate<Employee, String> biPre = (e, s) -> e.getName().equals(s);
	
	
	static Comparator<Employee> age = (e1, e2) -> e1.getAge() - e2.getAge();
	static Comparator<Employee> reversedNameAge = Comparator.comparing(Employee :: getName).thenComparing(age);
	
	public static void main(String[] args) {
		List<Employee> el = new ArrayList<Employee>();
		el.add(BuildInFunctionalInterfaces.sup1.get());
		el.add(BuildInFunctionalInterfaces.sup2.get());
		el.add(BuildInFunctionalInterfaces.sup3.get());
		el.add(BuildInFunctionalInterfaces.sup4.get());
		
		el.stream().filter(BuildInFunctionalInterfaces.pre).forEach(printer);
		
		System.out.println(Boolean.valueOf(pre.test(el.get(1))));
		System.out.println(upperCaseName.apply(el.get(0)));
		printer.accept(el.get(3));
		
		System.out.println(biPre.test(el.get(0), "Jerin"));
	}
	
	
}
