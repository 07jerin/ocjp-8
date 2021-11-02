package com.jerin.oracle.certification.programmer.innerclass;

public class MethodLocal {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.print();
		System.out.println();
		oc.print();
	}
}

class OuterClass {
	private int x = 1;

	public void print() {

		int y = 1;
		int z = 1;

//		z++; // The variable used inside should be effectively final or final
		x++;

		class Inner { // Only Abstract and final for method local inner classes

			public void print() {
				System.out.println("X " + x);
				System.out.println("Y " + y);
				System.out.println("Z " + z);
				System.out.println(OuterClass.this);
			}
		}

		Inner i = new Inner();
		i.print();

		int m = 10;
		S s = new S() {
			int m = 20;
			@Override
			public void test(int m) {
				 System.out.println(m);
				
			}
			 
		 };
		 

		 S s1 = t -> {
//			 int m = 20;
			 int c = 10;
			 System.out.println(m);
		 };
	}
 
}

interface S{
	public abstract  void test(int s);
}
