package com.jerin.oracle.certification.programmer.lambda;

import java.util.function.Supplier;

public class Scope {

	private int instance = 10;

	public static void main(String[] args) {

		Scope s = new Scope();
		s.instance = 600;
		Supplier<Scope> sup = s.getSupplier();
		sup.get();

		System.out.println();
		s.instance *= 2;
		sup.get();

	}

	public Supplier<Scope> getSupplier() {
		int method = 15;
		Supplier<Scope> sup = () -> {

			int instance = 300;
			int local = 120;
			local++;

//			int method = 50;
			
//			method++; // enclosing scope can't be overridden and should be effectively be final

			System.out.println("Local hidden Instance " + instance);
			System.out.println("Instance " + this.instance);
			System.out.println("local " + local);
			System.out.println("method " + method);
			this.instance  = 25;
			return null;
		};

		return sup;
	}

}
