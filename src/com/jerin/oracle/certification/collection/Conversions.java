package com.jerin.oracle.certification.collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Conversions {
	
	public static void main(String[] args) {
//		arraysToArraylist();
		
		Integer [] arr = {1,2};
		Object [] oArr = arr;
//		oArr[0] = "Hi there";
		
		System.out.println(oArr);

		arrayDequue();
	}


	private static void arrayDequue() {
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>(2);
		dq.add(1);
		dq.add(2);
		dq.add(3);
		System.out.println(dq.element());
		System.out.println(dq.peek());
		dq.offer(4);
		dq.push(-1);
		System.out.println(dq);
		System.out.println(dq.poll());
		System.out.println(dq.peek());
		System.out.println(dq.pop());
		System.out.println(dq);
		
	}
	

	private static void arraysToArraylist() {
		String [] sarr = {"H", "X","A", "B", "D", "Z", "C", "M"};
		List<String> sl11 = Arrays.asList(sarr);
		String val = sl11.remove(0);
		System.out.println(sl11);
		
		Integer [] iarr = {1,2,3,4};
//		int [] iarr = {1,2,3,4}; // Will not work in Arrays.asList
		List<Integer> il = Arrays.asList(iarr);
		System.out.println(il);
		
		iarr[0] = 0;
		System.out.println("List After updating the backing array list: " +il);
		il.set(1, 1);
//		il.add(5);// Throws RTE as we creted fixed size array list from array
		System.out.println("Array after updating the array list: " +Arrays.toString(iarr));
		
		Object [] oarr =  il.toArray(); 
		
		
		Integer [] iarr2 = new Integer[2]; // It will fill all 4 elements even if size is less, if size is more it will be retained
		iarr2 = il.toArray(iarr2);
		
		il.set(0, -1); // this change will not be reflected once new arrays are created using toArray
		
		System.out.println("new Object array after toArray from arrayList: " +Arrays.toString(oarr));
		System.out.println("new integer Array after toArray from arrayList: " +Arrays.toString(iarr2));
	}

}
