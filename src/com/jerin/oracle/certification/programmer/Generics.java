package com.jerin.oracle.certification.programmer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Generics {
	
	public <TU> List<TU> ob(List<TU> list){
		return list;
	}
	
	
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints =  new Generics().ob(ints);
		Generics.dequeue();
	}
	
	public static void dequeue () {
		Deque<String> dq = new ArrayDeque<String>();
		dq.push("A");
		dq.push("B");
//		dq.push("C");
//		dq.push("D");
		
		System.out.println(dq.remove());
		System.out.println(dq.remove());
		
		
		dq.add("A!");
		dq.add("B!");
		dq.add("C!");
		dq.add("D!");
		
		System.out.println(dq.pop());
		System.out.println(dq.remove());
		
		
	}

}
