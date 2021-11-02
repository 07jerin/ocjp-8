package com.jerin.oracle.certification.associate;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Overriding {

	public static void main(String[] args) {
//		A a = new B();
//		a.clean();
//		B b = new B();
//		b.clean();
//
//		System.out.println(a.name);
//		System.out.println(b.name);
		
//		Season s = Season.SUMMER;
//		Season s1 = Season.WINTER;
		System.out.println(Season.WINTER.name());
		System.out.println(Season.SUMMER.from());
		
	}

}

class A {
	public String name = "A";

	void clean() {
		System.out.println(name);
	}
}

enum Season{
	WINTER{
		public String from() {return "Winter";}
	}, SUMMER;
	
	private Season() {
		
		System.out.println("in constructor " + this.name());
	}
	
	public String from() {
		// TODO Auto-generated method stub
		return " aa";
	}
}

class B extends A {

	public String name = "B";

	void clean() {
		System.out.println(name);
	}
}
