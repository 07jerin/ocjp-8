package com.jerin.oracle.certification.programmer.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
	
	public static void main(String[] args) {
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		 
		Stream<String> va =  animals.flatMap(l -> l.stream());
		va
		.sorted()
		.forEach(System.out::println);
		
		
		Optional<Integer> optional = Optional.of(123);
		 optional.map(n -> "" + n)             // part 1
	     .filter(s -> s.length() == 4)      // part 2
	     .ifPresent(System.out::println);
		 
		 Map<Integer,List<String>> res =  Employee.getEmployees().stream()
//				 .limit(0)
				 .collect(Collectors
						 .groupingBy(Employee::getAge, Collectors
								 .mapping(Employee::getName, Collectors.toList())));
		 System.out.println(res);
		 
//		 Map<String, Integer> map = Stream.of("One", "Two", "Three").collect(Collectors.toMap(s-> s, String::length));
//		 System.out.println(map);
		 
		 TreeMap<Integer, String> map = Stream.of("One", "Two", "Three").collect(Collectors.toMap(String::length, s-> s, (s1, s2)-> s2, TreeMap::new));
		 System.out.println(map);
		 
//		 Map<String, Integer> map = Stream.of("One", "Two", "Three").collect(Collectors.toMap(s-> s, String::length));
//		 System.out.println(map);
	}

}
