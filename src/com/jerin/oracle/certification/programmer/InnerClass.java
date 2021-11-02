package com.jerin.oracle.certification.programmer;

public class InnerClass {
	public static void main(String[] args) {

		A.B ab = new A().new B();
		A.C ac = new A.C();
	}

}

class A {

	public void test() {
		B b = new B();
		C c = new C();
	}

	class B {

	}

	static class C {

	}
}
