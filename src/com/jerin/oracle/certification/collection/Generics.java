package com.jerin.oracle.certification.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jerin.oracle.certification.programmer.stream.Employee;

public class Generics {

	public static void main(String[] args) {
		methodReturnAndParameter();

		wildCardDeclarations();
	}

	private static void wildCardDeclarations() {
		// With ? extends 
				//		1. we can instantiate or pass in only sub class types 
				// 		2. We cant add anything event sub types
		
		List<?> wild = new ArrayList<Manager>();
		// with ? extends we cant add anything even though we can create and pass as method arguments
//		wild.add(new Object());
//		wild.add(new Manager());

		
//		List<Object> obj = new ArrayList<Manager>();
		
		
		List<? extends Employee> extendsWC = new ArrayList<SubManager>();
		// with ? extends we cant add anything even though we can create and pass as method arguments
//		extendsWC.add(new Object());
//		extendsWC.add(new Manager());
//		extendsWC.add(new Employee());
		
		
//		List<Employee> empList = new ArrayList<Manager>();
		

// ====================================================================================
// ====================================================================================
		
		
		// With ? super 
		//		1. we can instantiate or pass in only super class types 
		// 		2. We can add only sub types
//		List<? super Employee > superWC = new ArrayList<Manager>(); // since manager is sub class
		
		
		List<? super Manager> superWC = new ArrayList<Manager>();
//		superWC.add(new Object());
//		superWC.add(new Employee());
		// with ? super Can add only anything Manager or sub class of Manager
		superWC.add(new Manager());
		superWC.add(new SubManager());
//		SubManager sub = superWC.get(0); // Get returns Object as ? super
		
//		List<? super Manager> superWC = new ArrayList<SubManager>();
		// Even though we can add only sub classes of Manager,
		
		List<? super SubManager> superWCObject = new ArrayList<Object>();
		// Can add only anything SubManager or sub class of SubManager
//		superWCObject.add(new Manager());// Will not work
	}

	private static void methodReturnAndParameter() {
		List<Object> objLiist = new ArrayList<>();
		objLiist.add(1);
		objLiist.add(new Employee());
//		setEmployeeList(objLiist);
//		setTExtendsEmployeeList(objLiist);
		setNonGenericList(objLiist);

		List<Manager> managers = new ArrayList<>();
//		managers.add(1);
		managers.add(new Manager());
//		setEmployeeList(managers);
		setTExtendsEmployeeList(managers);
		setNonGenericList(managers);

		List oldList = new ArrayList();
		oldList.add(1);
		oldList.add(new Manager());
		setEmployeeList(oldList);
		setTExtendsEmployeeList(oldList);
		setNonGenericList(oldList);
	}

	private static <T extends Employee> List<Employee> setEmployeeList(List<Employee> el) {
//		List<Object> objLiist = new ArrayList<>();
//		return objLiist; // will not work

//		List<Manager> managers = new ArrayList<>();
//		return managers; // will not work !

		// Can add as we are not using extends
		el.add(new Manager());
		el.add(new Employee());

		List oldList = new ArrayList();
		return oldList;
	}

	private static <T extends Employee> List<T> setTExtendsEmployeeList(List<T> el) {
		// Cant add as we are using extends
//		el.add(new Manager());
//		el.add(new Employee()); // Cant Add
		return el;
	}

	private static void setNonGenericList(List el) {
	}
	
	private static List<Integer> get(){
		ArrayList<Integer> x = null;
		return x ;
	}

}

class Manager extends Employee {
}

class SubManager extends Manager {
}


	
