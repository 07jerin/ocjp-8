package com.jerin.oracle.certification.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.jerin.oracle.certification.programmer.stream.Employee;

public class Java8APIs {
	
	public static void main(String[] args) {
		
//		listAPIS();
		
		mergeInMap();
		
		
	}

	private static void mergeInMap() {
		Map<Integer, List<String>> ageMap = Employee.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee :: getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
		
		System.out.println(ageMap);
		
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		System.out.println(favorites.put("Tom", null));
		System.out.println(favorites.put("Jerin", "Flight"));
		System.out.println(favorites.put("Jerin", "Boat"));

		System.out.println(favorites.putIfAbsent("Jenny", "Tram"));
		System.out.println(favorites.putIfAbsent("Sam", "Tram"));
		System.out.println(favorites.putIfAbsent("Tom", "Tram"));
		System.out.println(favorites); 
		
		System.out.println();
		System.out.println("Merge");
		
		String jerin = favorites.merge("Jerin", "Pack", (String v1, String v2) ->{
			System.out.println(v1 + " : " + v2);
			return v2;
		});
		
		System.out.println(jerin);
		System.out.println(favorites);
		System.out.println();
		
		String tom = favorites.merge("Tom", "Pack", (String v1, String v2) ->{
			System.out.println(v1 + " : " + v2);
			return null;
		});
		
		System.out.println(tom);
		System.out.println(favorites);
		System.out.println();
		
		String none = favorites.merge("None", "Pack", (String v1, String v2) ->{
			System.out.println(v1 + " : " + v2);
			return v2;
		});
		
		System.out.println(none);
		System.out.println(favorites);
		System.out.println();
		
		
		String newbe = favorites.merge("newbe", "newValue", (String v1, String v2) ->{
			System.out.println(v1 + " : " + v2);
			return v1;
		});
		
		System.out.println(newbe);
		System.out.println(favorites);
		System.out.println();
		
		
		System.out.println(favorites);
		String nullbe = favorites.merge("newbe", "newValue", (String v1, String v2) ->{
			System.out.println(v1 + " : " + v2);
			return v1;
		});
		
		System.out.println(nullbe);
		System.out.println(favorites);
		System.out.println();
		
		
		
		String npe = favorites.merge("newbe", null, (String v1, String v2) ->{
			System.out.println(v1 + " : " + v2);
			return v1;
		});
		
		System.out.println(nullbe);
		System.out.println(favorites);
		System.out.println();
	}

	private static void listAPIS() {
		List<Integer> ls = IntStream.rangeClosed(0, 25)
				.mapToObj(Integer :: valueOf)
				.collect(Collectors.toList());
		
		ls.removeIf( i -> i > 10);
		System.out.println(ls);
		
		List<String> es = Employee.getEmployees()
				.stream()
				.map(Employee :: getName)
				.collect(Collectors.toList());
		es.removeIf(n -> n.startsWith("J"));
		System.out.println(es);
		
		
		es.replaceAll(String :: toUpperCase);
		System.out.println(es);
	}

}
