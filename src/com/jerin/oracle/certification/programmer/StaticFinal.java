package com.jerin.oracle.certification.programmer;

public class StaticFinal {
	
public static final String me;
	
	static{
		System.out.println("First Static");
		me = "Jerin";
	}
	
	static {
		System.out.println("Second Static");
	}
		
	
	public static void test() {
		System.out.println("Static Final Test");
		
	}
	
	
	

}
