package com.jerin.oracle.certification.programmer.lambda;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class BuildInSubFunctionalInterfaces {
	
	public static void main(String[] args) {
		primitiveSuppliers();
	}

	private static void primitiveSuppliers() {
		Random r = new Random();
		
		IntSupplier isup = () -> r.nextInt();
		int val = isup.getAsInt();
		
		
		LongSupplier lsup = () -> r.nextLong();
		long lval = lsup.getAsLong();
	}

}
