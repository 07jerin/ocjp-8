package com.jerin.oracle.certification.associate.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class Generics {

	public static void main(String[] args) {
		Set<Magazine1> set = new TreeSet<>();
		set.add(new Magazine1("highlights"));
		set.add(new Magazine1("Newsweek"));
		set.add(new Magazine1("highlights"));
		System.out.println(set.iterator().next());
		System.out.println(set);
		
		BiFunction<String, String, String> combinator = String :: concat;
		System.out.println(combinator.apply("Jerin ", "Joseph"));
		
		BiFunction<String, Integer, Character> charAT = String :: charAt;
		System.out.println(charAT.apply("Jerin", 0));
	}
	
	
	
}

class Magazine1 implements Comparable<Magazine1> {
	private String name;

	public Magazine1(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Magazine1 m) {
		return name.compareTo(m.name);
	}

	@Override
	public String toString() {
		return name;
	}
}
