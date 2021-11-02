package com.jerin.oracle.certification.programmer.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable, Comparable<Employee>{

	private String name;
	private int rollNo;
	private int age;
	
	public Employee() {
		
	}

	public Employee(String name, int rollNo, int age) {
		this.age = age;
		this.name = name;
		this.rollNo = rollNo;
	}

	public static void print() {
		System.out.println("Static Print");
	}

	public void printMe() {
		System.out.println("Print " + this.name);
	}

	public void printMe2(Integer a, Integer b) {
		System.out.println("Print " + this.name);
	}

	public void printMe1(Object e) {
//		System.out.println("Employee " + ((Employee)e).name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
//	@Override
//	public int hashCode() {
//		return 1;
//	}
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((Employee)obj).getName());
	}

	@Override
	public String toString() {
		return this.name + ", " + this.getAge() + ", " + this.rollNo;
	}

	public static List<Employee> getEmployees() {
		List<Employee> el = new ArrayList<Employee>();
		el.add(new Employee("Jerin", 1, 32));
		el.add(new Employee("Joseph", 2, 65));
		el.add(new Employee("Mark", 3, 30));
		el.add(new Employee("Mathew", 4, 40));
		el.add(new Employee("Ruben", 5, 9));
		el.add(new Employee("Staphy", 6, 30));
		el.add(new Employee("Jaisy", 7, 37));
		el.add(new Employee("Jeff", 8, 27));
		el.add(new Employee("Tom", 9, 30));
		el.add(new Employee("Alice", 10, 30));
		el.add(new Employee("Linux", 11, 30));
		el.add(new Employee("25 Name", 251, 40));
		return el;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
