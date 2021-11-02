package com.jerin.oracle.certification.programmer.lambda;

import java.util.function.BiPredicate;
import java.util.function.DoubleFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import com.jerin.oracle.certification.common.PrintUtil;
import com.jerin.oracle.certification.programmer.stream.Employee;

public class DefaultInterfaces {

	public static void main(String[] args) {
		
		PrintUtil.spacer("DoubleFunction");
		DoubleFunction<String> square = (double d) -> "Square is " + d * d;
		System.out.println(square.apply(10));
		
		PrintUtil.spacer("Predicate");
		Predicate<Employee> olderThan30 = e -> e.getAge() > 30;
		Employee.getEmployees().stream().filter(olderThan30).forEach(System.out :: println);
		
		PrintUtil.spacer("Bi Predicate");
		BiPredicate<Employee, Integer> isOlderThan = (e, age) -> e.getAge() > age; 
		Employee.getEmployees().forEach(e -> {
			if(isOlderThan.test(e, 30)) {
				System.out.println(e);
			}
		});
		
		PrintUtil.spacer("Unary Operator");
		UnaryOperator<String> upperCase = s -> s.toUpperCase();
		System.out.println(upperCase.apply(new Employee("Jerin", 1, 32).getName()));
		
	
	}

}
