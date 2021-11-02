package com.jerin.oracle.certification.collection;

public class ComplexGenerics {
	public static void main(String[] args) {

		X1<String> x1Obj1 = new X1<String>("Jerin");
		System.out.println(x1Obj1.getX());

//		X1<String> x1Obj2 = new X1<Integer>(1); // error
		X1<Integer> x1Obj3 = new X1<Integer>(1);
		System.out.println(x1Obj3.getX());

		X1<String> x1Obj4 = new X1(1);
		// will not throw error above, but warns not typesafe here but throws RTE below
//		System.out.println(x1Obj4.getX());

		X<String> xObj1 = new X("Jerin");

		// the type X get precedence of class type, therefore the following is CTE
//		X<String> xObj2 = new X<String>(xObj1); 
		System.out.println(xObj1.getX());

		// Wild card can be used for variable declarations
		X<? extends Number> test = new X<Integer>(1);
//		X<? extends Number> test1 = new X<String>("Jerin"); // CTE 
		
		M m = new M();
		
		String name = M.identity("jerin");
		Integer n0 = M.<Integer>identity(1);
		
		String name1 = m.identity1("jerin");
		Integer n01 = m.<Integer>identity1(1);

	}
}

// Wild card is allowed only when we declare variables and not for Method and class declarations 
//class X<? extends Number>{}

class M{
	static <U> U identity(U u) {
		return u;
	}
	
	 <U> U identity1(U u) {
		return u;
	}
}

class X1<T> {

	T t;

	public X1(T t) {
		this.t = t;
	}

	T getX() {
		return this.t;
	}
	
	static <U> U identity(U u) {
		return u;
	}
	
	 <U> U identity1(U u) {
		return u;
	}

}

//Valid class with valid constructor with same X used as class name as well as type Name
class X<X> {

	X x;

	public X(X x) {
		this.x = x;
	}

	X getX() {
		return this.x;
	}

}
