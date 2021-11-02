package com.jerin.oracle.certification.programmer.stream;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
	public static void main(String[] args) {
		
		List<MethodReference> list = new ArrayList<MethodReference>();
		list.add(new MethodReference("test"));
		
		
		//staticMethod
		list.stream()
//			.forEach(MethodReference :: staticPrint); // error
			.forEach (MethodReference :: staticPrintWithParam);
			
		
		
		//instanceMethod
		list.stream()
			.forEach(MethodReference :: printInstance);
		
		
		//instanceMethod of an arbitrary object of a particular type
		list.stream()
//		.forEach(System.out :: println);
//		.forEach(NewClass.instance :: printMethodReference);
		.forEach(NewClass.instance :: printObject);
		
		// Constructor
		list.stream()
			.forEach(MethodReference :: new);
			
	}
	
	public MethodReference() {
		
	}
	
	public MethodReference (String ref) {
		System.out.println("In String constructor");
	}
	
	public MethodReference (MethodReference ref) {
		System.out.println("In parameterized constructor");
	}

	public static void staticPrint() {
		System.out.println("Print static Method");
	}
	
	public static void staticPrintWithParam(MethodReference ref) {
		System.out.println("Print static Method with paramm");
	}
	
	public void printInstance() {
		System.out.println("print Instance");
	}
}

class NewClass{
	
	
	public static NewClass instance = new NewClass();
	
	public void printObject(Object ob) {
		System.out.println("Print ob");
	}
	
	public void printMethodReference(MethodReference  ob) {
		System.out.println("print MethodReference");
	}
	
	public void emptyPrint() {
		System.out.println("EMPTY");
	}
}


