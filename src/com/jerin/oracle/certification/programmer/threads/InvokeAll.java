package com.jerin.oracle.certification.programmer.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll {

	public static void main(String[] args) {
		Callable<Integer> val = () -> {
			System.out.println("Callable " + Thread.currentThread().getName());
//	Thread.sleep(3000); 
			return 3;
		};

		List<Callable<Integer>> vals = new ArrayList<>();
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
		vals.add(val);
//		vals.add(r);
//		vals.add(r);

		System.out.println("Before Invoke");

		ExecutorService es = Executors.newFixedThreadPool(2);
		try {
			List<Future<Integer>> ret = es.invokeAll(vals);
//			Integer ret = es.invokeAny(vals);
//			System.out.println(ret);
			System.out.println(ret.get(0).get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			((Throwable) e).printStackTrace();
		}

		System.out.println("After invoke");
		
		es.shutdown();
	}

}
