package com.jerin.oracle.certification.programmer.main;

import com.jerin.oracle.certification.programmer.StaticFinal;

public class MainClass {
	static {
		System.out.println("Main Static");
	}

	public MainClass() {
		System.out.println("In Main Construtor");
		StaticFinal fn = new StaticFinal();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		StaticFinal.test();
		test();
		new MainClass();
		new MainClass();
	}

	private static void test() {
		System.out.println("Test");

	}
}
