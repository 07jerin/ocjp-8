package com.jerin.oracle.certification.programmer;

public class StaticInheritance {

	public static void main(String[] args) {
//		StaticSub.print();
//		Istatic s = new StaticSub();
//		Istatic.iPrint();
		Istatic s1 = new StaticSub();
//		s1.iPrint();
		Istatic.iPrint();

	}
}

interface Istatic {
	public static void iPrint() {
		System.out.println(" iPrint");
	}
}

class StaticSuper {
	final int val;

	StaticSuper() {
		val = 10;
	}

	public static void print() {
		System.out.println(" Static print A");
	}
}

class StaticSub extends StaticSuper implements Istatic {

}
