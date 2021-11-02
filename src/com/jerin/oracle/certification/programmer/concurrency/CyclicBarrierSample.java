package com.jerin.oracle.certification.programmer.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {
	
	public static void main(String[] args) {
		List<Integer> till100 = new ArrayList<Integer>();
		List<Integer> till200 = new ArrayList<Integer>();
		List<Integer> till300 = new ArrayList<Integer>();
		
		
		CyclicBarrier cb = new CyclicBarrier(2, ()->{
			
			System.out.println(Thread.currentThread().getName() + " start CB");
			System.out.println(till100);
			System.out.println(till200);
			System.out.println(till300);
			System.out.println();
			List<Integer> finalList = new ArrayList<Integer>();
			finalList.addAll(till100);
			finalList.addAll(till200);
			finalList.addAll(till300);
			System.out.println(finalList);
			
		});
				
		Thread t1 = new Thread(new  NumberGenerator(cb, till100, 0), "Till 100");
		Thread t2= new Thread(new  NumberGenerator(cb, till200, 100), "Till 200");
		Thread t3= new Thread(new  NumberGenerator(cb, till300, 200), "New");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	

}

class NumberGenerator implements Runnable {
	CyclicBarrier cb;
	List<Integer> data;
	int start;
	
	NumberGenerator(CyclicBarrier cb, List<Integer> data, int start ){
		this.cb = cb;
		this.data = data;
		this.start = start;
	}
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Starts");
		for(int i = start; i< start+100; i++  ) {
			data.add(i);
		}
		
		try {
			cb.await();
			System.out.println(Thread.currentThread().getName() + " Itermediate");
			Thread.sleep(1000);
			for(int i = start; i< start+100; i++  ) {
				data.add(i);
			}
//			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Proceeds");
		
		
	}
	
	
}
