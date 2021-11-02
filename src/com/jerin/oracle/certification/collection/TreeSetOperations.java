package com.jerin.oracle.certification.collection;

import java.util.LinkedHashMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.jerin.oracle.certification.common.PrintUtil;

public class TreeSetOperations {

	public static void main(String[] args) {
		navigable();
		backedCollections();
		

	}

	private static void backedCollections() {
		PrintUtil.spacer("Backed collections");
		NavigableSet<Integer> values = new TreeSet<Integer>();

		values.add(90);
		values.add(20);
		values.add(30);
		values.add(70);
		values.add(80);
		values.add(40);
		values.add(50);
		values.add(100);
		values.add(60);
		values.add(10);

		SortedSet<Integer> _50_70 = values.subSet(50, 70);
		NavigableSet<Integer> _60_x = values.tailSet(60, true);
		NavigableSet<Integer> _0_40 = values.headSet(40, true);

//		_50_70.add(75); out of range
		_50_70.add(61); // add 61
		_60_x.pollLast(); // Remove 100
		_60_x.pollFirst(); // Remove 60
		_0_40.add(35);

		System.out.println("_60_x " + _60_x);
		System.out.println(values);
	}

	private static void navigable() {
		NavigableSet<Integer> values = new TreeSet<Integer>();
		
		values.add(90);
		values.add(20);
		values.add(30);
		values.add(70);
		values.add(80);
		values.add(40);
		values.add(50);
		values.add(100);
		values.add(60);
		values.add(10);
		
		System.out.println("Next value higher than 85 : " + values.higher(85));
		System.out.println("Next value lower than 85 : " + values.lower(85));

		System.out.println("Next value lower than 5 : " + values.lower(5));
		
		System.out.println("Next value >= 50 : " + values.ceiling(50));
		System.out.println("Next value <= 50 : " + values.floor(50));
		
		System.out.println("Next value >= 51 : " + values.ceiling(51));
		System.out.println("Next value <= 51 : " + values.floor(51));
		
		System.out.println("First value  : " + values.first());
		
		System.out.println("First value polled  : " + values.pollFirst());
		System.out.println("First value  polled : " + values.pollFirst());
		System.out.println("Last value  polled : " + values.pollLast());
		
		values = values.descendingSet();
		
		System.out.println("After desc sort");
		System.out.println("First value polled  : " + values.pollFirst());
		System.out.println("First value  polled : " + values.pollFirst());
		System.out.println("Last value  polled : " + values.pollLast());
		
		
		System.out.println("Remaining values");
		values.stream().forEach(System.out :: println);
		
		
		
		
	}

}
