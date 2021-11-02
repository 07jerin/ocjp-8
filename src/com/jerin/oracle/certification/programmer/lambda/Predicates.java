package com.jerin.oracle.certification.programmer.lambda;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.jerin.oracle.certification.programmer.stream.Employee;

public class Predicates {

	public static void main(String[] args) {
//		defaultMethods();
//
//		staticEquals();
//
//		otherPredicates();
		
		Predicate<String> egg = s -> s.contains("egg");
		BiPredicate<String, String> egg2 = String::contains;
		
		System.out.println(egg2.test("Eggs", "Egg"));
	}

	private static void otherPredicates() {
		IntPredicate ip = i -> i < 10;
		System.out.println(ip.test(5));

		BiPredicate<String, Integer> bp = (n, a) -> n.startsWith("J") && a < 30;
		Consumer<Employee> consumer = c -> {
			if (bp.test(c.getName(), c.getAge())) {
				System.out.println(c);
			}
		};
		Employee.getEmployees().forEach(consumer);
	}

	private static void staticEquals() {
		System.out.println("Equals test");
		Employee jerin = new Employee("Jerin", 1, 32);
		Predicate<Employee> isJerin = Predicate.isEqual(jerin);
		List<Employee> el = Employee.getEmployees();
		el.removeIf(isJerin);
		System.out.println(el.size());
	}

	private static void defaultMethods() {
		Predicate<Employee> ageGT40 = e -> e.getAge() > 40;
		Predicate<Employee> ageLT20 = e -> e.getAge() < 20;

		Predicate<Employee> ageGT20Verbose = e -> ageLT20.negate().test(e);
		Predicate<Employee> ageGT20Simple = ageLT20.negate();

		List<Employee> el = Employee.getEmployees();
		System.out.println(el.size());

		el.removeIf(ageGT40.and(ageLT20));
		System.out.println(el.size());

		el = Employee.getEmployees();
		el.removeIf(ageGT40.or(ageLT20));
		System.out.println(el.size());

		el = Employee.getEmployees();
		el.removeIf(ageGT40.or(ageLT20).negate());
		System.out.println(el.size());

	}
}
