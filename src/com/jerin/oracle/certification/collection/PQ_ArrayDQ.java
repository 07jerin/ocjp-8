package com.jerin.oracle.certification.collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PQ_ArrayDQ {

	public static void main(String[] args) {
		priorityQueue();

		arrayDQ();

	}

	private static void arrayDQ() {
		ArrayDeque<String> dq = new ArrayDeque<>(); // Grows
		dq.add("add");
		dq.add("add1"); // always add in end
		dq.addLast("addLast");
		dq.addLast("addLast1");
		dq.addFirst("addFirst");
		dq.push("push");
		dq.offer("offer");
		dq.offerLast("offerLast");
		dq.offerFirst("offerFirst");

		System.out.println(dq);
	}

	private static void priorityQueue() {
		List<Integer> ls = Arrays.asList(3, 5, 6, 1, 2, 4, 7);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pqRev = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (Integer i : ls) {
			pq.offer(i);
			pqRev.offer(i);
		}

		System.out.println("Pq poll " + pq.poll());
		System.out.println("Pq peek " + pq.peek());
		System.out.println("Pq poll " + pq.poll());

		System.out.println("PqRev poll " + pqRev.poll());
		System.out.println("PqRev poll " + pqRev.peek());
		System.out.println("PqRev poll " + pqRev.poll());
	}

}
