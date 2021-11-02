package com.jerin.oracle.certification.programmer.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jerin.oracle.certification.programmer.io.IOFiles;
import com.jerin.oracle.certification.programmer.properties.PropertiesTry;
import com.jerin.oracle.certification.programmer.stream.Employee;

public class Serialization {
	static String serializeFile = IOFiles.fileNamePrefix + "serialized.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Office of = new Office(Employee.getEmployees());
		Office.name = "New Office";
		of.id = 10;
		of.phone = 200;
		of.leader = of.employees.get(0);
		
		System.out.println(of);
		serialize(of);
		
		System.out.println();
		
		Office.name = "XXXXXXXXXXXX";
		deSerialize();

	}

	private static void serialize(Office office) throws IOException {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(serializeFile))) {
			os.writeObject(office);
		}
	}

	private static void deSerialize() throws IOException, ClassNotFoundException {

		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(serializeFile))) {
			Office of = (Office) is.readObject();
			System.out.println(of);
			of.employees.forEach(System.out::println);
		}
	}

}

class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	transient int totalEmployees = -1;
	transient double random;
//	Object x = new Object();
	static String name = "";
	Employee leader;
	int phone;
	int id;
	List<Employee> employees = new ArrayList<Employee>();

	public Office(List<Employee> employees) {
		phone = 123456789;
		name = "Office Name";
		totalEmployees = employees.size();
		this.employees = employees;
		this.random= Math.random();
	}

	private void addEmpl(Employee e) {
		++totalEmployees;

	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(this.random);
	}
	
	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		is.defaultReadObject();
		double random = (double)is.readObject();
		this.random = random;
		this.totalEmployees = this.employees.size();
	}

	public String toString() {
		return name + "#" + id + " : " + phone + " : " + totalEmployees + " : Random : "+ this.random + " - " + leader + " ";
	}

}
