package com.jerin.oracle.certification.programmer.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

import com.jerin.oracle.certification.programmer.stream.Employee;

public class Consumers {

	public static void main(String[] args) {
		primitives();

		biConsumers();

		andThen();

	}

	private static void andThen() {
		//Types should exactly match and cant chain inline
		System.out.println();
		List<Employee> employees = Employee.getEmployees();
		Consumer<Employee> agePrinter = e -> System.out.print(" " + e.getAge() + ",");
		Consumer<Employee> ageDoubler = e -> e.setAge(e.getAge() * 2);
		Consumer<Employee> spacer = e -> System.out.print("-");
		employees.forEach(agePrinter.andThen(ageDoubler).andThen(spacer).andThen(agePrinter));
	}

	private static void biConsumers() {
		System.out.println();
		List<Employee> employees = Employee.getEmployees();
		Consumer<Employee> agePrinter = e -> System.out.print(e.getAge() + ",");
		Consumer<Employee> ageDoubler = e -> e.setAge(e.getAge() * 2);
		employees.forEach(agePrinter);
		employees.forEach(ageDoubler);
		System.out.println();
		employees.forEach(agePrinter);
		System.out.println();
		BiConsumer<List<Employee>, Map<Integer, Employee>> addToMap = (el, map) -> {
			el.forEach(e -> map.put(e.getRollNo(), e));
		};

		System.out.println();
		Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		addToMap.accept(employees, employeeMap);
		BiConsumer<Integer, Employee> mapPrinter = (i, e) -> System.out.println(i + " : " + e.getName());
		employeeMap.forEach(mapPrinter);
	}

	private static void primitives() {
		IntConsumer iCon = i -> System.out.println(++i);
		iCon.accept(10);

		ObjIntConsumer<Employee> setAge = (e, i) -> e.setAge(i);
		Employee emp = new Employee("Tes", 56854, 5);
		setAge.accept(emp, 50);
		System.out.println(emp);

		System.out.println();
		BiConsumer<Employee, ObjIntConsumer<Employee>> biConsumer = (e, ic) -> ic.accept(e, 25);
		biConsumer.accept(emp, setAge);
		System.out.println(emp);
	}

}
