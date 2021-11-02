package com.jerin.oracle.certification.collection;

import java.util.HashMap;
import java.util.Map;

public class APIS {
	
	public static void main(String[] args) {
		Map<Integer, Integer> map  = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, 30);
		map.put(4, 40);
		map.put(-1, null);
//		map.merge(1, 100, (a, b) -> {System.out.println(a + " " + b); return a+b;});
//		map.merge(2, 100, (a, b) -> {System.out.println(a + " " + b); return null;});
//		map.merge(-1, 100, (a, b) -> {System.out.println(a + " " + b); return a+b;});
//		map.merge(-2, 100, (a, b) -> {System.out.println(a + " " + b); return a+b;});
		map.merge(-3, null, (a, b) -> {System.out.println(a + " " + b); return a+b;});
//		map.merge(-1, 100, null);
		System.out.println(map);
	}

}
