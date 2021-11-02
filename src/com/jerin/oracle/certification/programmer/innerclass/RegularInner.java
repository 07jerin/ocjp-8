package com.jerin.oracle.certification.programmer.innerclass;

public class RegularInner {

	public static void main(String[] args) {
		Outer.staticFunc();
		Outer o = new Outer();
		o.innerPrint();
		o.innerPrint();
	}

	public void testLikeStatic() {
		Outer.Inner inner = new Outer().new Inner();
		inner.print();
	}

}

class Outer {

	private int val = 10;

	static void staticFunc() {
		Outer.Inner inner = new Outer().new Inner();
		inner.print();
	}

	void innerPrint() {
		Inner inner = new Inner();
		inner.print();
	}

	class Inner {

		public int val = 5;

		public void print() {
			Outer.this.val++;// Generally you dont need this, but in this case val is shadowed 
			++val;
			System.out.println("Inner val : " + val + " Outer val : " + Outer.this.val);
		}
	}
}
