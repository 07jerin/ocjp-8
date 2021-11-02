package com.jerin.oracle.certification.associate;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		System.out.println("Hello".substring(0,1));
		System.out.println("Hello".substring(1,"Hello".length()));
	
		int [] test = new int[10];
		int x = test.length;
		List<Integer> tes = new ArrayList<Integer>();
		tes.add(1);
		tes.add(2);
		tes.add(3);
		tes.add(4);
		
		Integer val = 1;
		
		tes.remove(val);
		
		System.out.println(tes);
		
		int a = -1;
		if(a > 0)
			System.out.println(a);
		System.out.println("After");
//		else {
//			System.out.println("Else");
//		}
	}
	
	public static String a;
	
	
	public static void  test() {
		
		
	}
	
	static int test(int a) {
		return a;
	}

}
