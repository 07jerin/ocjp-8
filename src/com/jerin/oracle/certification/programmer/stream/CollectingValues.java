package com.jerin.oracle.certification.programmer.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jerin.oracle.certification.common.PrintUtil;
import com.jerin.oracle.certification.programmer.io.IOFiles;

public class CollectingValues {

	public static void main(String[] args) {
		List<Employee> el = Employee.getEmployees();
//		modifySourceCreatesNPE();

		collectToList(el);

		simpleReadFile();

		collectEmployeesFromFile();
		  
		groupingBy(el);
		
		partitionBy(el);
		
		PrintUtil.spacer();
		averagingSumming(el);
		
		PrintUtil.spacer();
		long count = el.stream().collect(Collectors.counting());
		Map<Integer, Long> groupByCounts = el.stream().collect(Collectors.groupingBy(Employee :: getAge, Collectors.counting()));
		System.out.println("Count : " + count + " Group by " + groupByCounts);
		
		String names = el.stream().filter(e -> e.getAge()>30).map(Employee :: getName).collect(Collectors.joining(","));
		System.out.println("Age > 30 " + names);
		
		Comparator<Employee> ageComparator = (e1, e2) -> e1.getAge() - e2.getAge();
		Optional<Employee> oldest = el.stream().collect(Collectors.maxBy(ageComparator));
		Optional<Employee> youngest = el.stream().collect(Collectors.minBy(ageComparator));
		System.out.println("oldest " + oldest + " youngest " + youngest);
		
		
	
	}

	private static void averagingSumming(List<Employee> el) {
		Function<Employee, Integer> ageFunc = e -> e.getAge();
		Map<Integer, Integer> sumOfAges = el.stream()
				.collect(Collectors.groupingBy(ageFunc, Collectors.summingInt(e -> e.getAge())));

		System.out.println("Grouping By sumOfAgesBY30 " + sumOfAges);

		Map<Boolean, Integer> sumOfAgesBY30 = el.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 30, Collectors.summingInt(Employee::getAge)));
		System.out.println("Partition sumOfAgesBY30 " + sumOfAgesBY30);
		
		Map<Integer, Double> avgGroupByAge = el.stream()
				.collect(Collectors.groupingBy(ageFunc, Collectors.averagingInt(Employee :: getAge)));
		System.out.println("avgGroupByAge " + avgGroupByAge);
		
		Map<Boolean, Double> avgPartitionByAge30 = el.stream()
				.collect(Collectors.partitioningBy(e-> e.getAge() > 30, Collectors.averagingInt(Employee:: getAge)));
		System.out.println("avgPartitionByAge30 " + avgPartitionByAge30);
	}

	private static void partitionBy(List<Employee> el) {
		System.out.println();
		System.out.println("Partiton");
		Predicate<Employee> ageGT30 = e -> e.getAge() > 30;
		Map<Boolean, List<Employee>> partion = el.stream().collect(Collectors.partitioningBy(ageGT30));
		System.out.println("Simple parition " + partion);

		Map<Boolean, Long> partitionByCount = el.stream()
				.collect(Collectors.partitioningBy(ageGT30, Collectors.counting()));
		System.out.println("Partition by count : " + partitionByCount);

		Map<Boolean, List<String>> partitionByName = el.stream().collect(
				Collectors.partitioningBy(ageGT30, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Partition by Name : " + partitionByName);
	}

	private static void groupingBy(List<Employee> el) {
		System.out.println();
		System.out.println("Grouped by age");
//		Map<Integer, List<Employee>> ageGrouped =  el.stream().collect(Collectors.groupingBy(e-> e.getAge()));
		Map<Integer, List<Employee>> ageGrouped = el.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println(ageGrouped);

		Map<Integer, Long> groupByAgeCounts = el.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
		System.out.println("Grouped by age, counts");
		System.out.println(groupByAgeCounts);

		Map<Integer, List<String>> groupByAgeNames = el.stream().collect(
				Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Grouped by age, Names");
		System.out.println(groupByAgeNames);
	}

	private static void collectEmployeesFromFile() {
		System.out.println();
		System.out.println("Read Employees from file");
		try (Stream<String> s = Files.lines(Paths.get(IOFiles.fileNamePrefix, "employees.txt"))) {
			List<Employee> employees =  s.map(line -> {
				String[] attr = line.split("/");
				return new Employee(attr[0], Integer.valueOf(attr[1]), Integer.valueOf(attr[2]));
			}).collect(Collectors.toList());
			employees.forEach(e -> System.out.print(" :: " + e));

		} catch (IOException e) {

		}
	}

	private static void simpleReadFile() {
		System.out.println();
		System.out.println("Red from file to list");
		try(Stream<String> lines = Files.lines(Paths.get(IOFiles.fileNamePrefix, "file1.txt"))){
			List<String> fileLines = lines.collect(Collectors.toList());
			fileLines.forEach(System.out :: println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void collectToList(List<Employee> el) {
		System.out.println("Age > 30");
		List<Employee> elGT30 = el.stream()
			.filter(e -> e.getAge() > 30)
			.collect(Collectors.toList());
		
		ArrayList<Employee> elGT30AL = el.stream()
				.filter(e -> e.getAge() > 30)
//				.collect(Collectors.toCollection(() -> new ArrayList<Employee>()));
				.collect(Collectors.toCollection(ArrayList ::  new));
		
		elGT30.stream()
		.forEach(e -> System.out.print(" :: " + e));
			
		System.out.println();
	}

	private static void modifySourceCreatesNPE() {
		List<Employee> el = Employee.getEmployees();
		el.stream().filter(e ->{
			if(e.getAge() <= 30) {
				el.remove(e);
//				return false;
			}
			return true;
		}).forEach(System.out :: println);
	}

}
