package com.jerin.oracle.certification.programmer.innerclass;

public class StaticInner {

	public static void main(String[] args) {
//		// Not possible as static class is not specific to instance
//		StaticOuter.StaticInner obj = new StaticOuter().new StaticInner(); 
		StaticOuter.StaticInner obj1 = new StaticOuter.StaticInner();
		obj1.print();

	}

}

class StaticOuter {
	private int x = 10;
	private static int y = 10;

	static class StaticInner {
		void print() {
//			System.out.println("X" + x); // Not possible as non static member of outer
			System.out.println("Y : " + y);
		}
	}
}
