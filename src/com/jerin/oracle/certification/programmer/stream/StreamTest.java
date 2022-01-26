package com.jerin.oracle.certification.programmer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamTest {
	
	public static void main(String[] args) {
		new StreamTest().test();
		
		int[] vals = {1,2,3};
//		Arrays.stream(vals).asLongStream().sum()
	}
	
	public static void staticTest() {
		System.out.println("StreamTest :: staticTest");
	}
	
	public static String staticTest2(Object w) {
		System.out.println("StreamTest :: staticTest2");
		return "S";
	}
	
	public static void staticTest(Employee e) {
		System.out.println("StreamTest :: staticTest " + e.toString());
	}
	
	public void test() {
		
		 Function <Object, String> func = StreamTest :: staticTest2;

		 String newValue = func.apply("Jerin");
		 System.out.println(newValue);
		
		List<Employee> el = new ArrayList<Employee>();
		el.add(new Employee("Jerin", 0, 10));
		el.add(new Employee("Jose", 0, 20));
		el.add(new Employee("Mark", 0, 30));
		el.add(new Employee("Mathew", 0, 40));
		
		Employee obj = new Employee("EMPTY", 0, 0);
		
		el.stream().filter(agePredicate).forEach(Employee :: printMe);
		el.stream().filter(agePredicate).forEach(obj :: printMe1);
		el.stream().filter(agePredicate).forEach(System.out :: println);
		el.stream().filter(agePredicate).forEach(StreamTest :: staticTest);
//		el.stream().filter(agePredicate).forEach(StreamTest :: staticTest);
	}
	
	Predicate<Employee> agePredicate = e -> e.getAge() > 10;

}
