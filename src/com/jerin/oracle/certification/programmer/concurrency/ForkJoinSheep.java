package com.jerin.oracle.certification.programmer.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSheep {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		int sum = pool.invoke(new WeighAnimalAction(new Double[] { 1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d , 11d, 12d, 13d}, 0, 12));

		System.out.println(sum);
	}

}

class WeighAnimalAction extends RecursiveTask<Integer> {
	private int start;
	private int end;
	private Double[] weights;
	private int sum;

	public WeighAnimalAction(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	protected Integer compute() {
	      if(end-start <= 3) {
			for (int i = start; i < end; i++) {
				sum += weights[i];
				System.out.println(i);
			}
	      }
	       
	      else {
	         int middle = start+((end-start)/2);
	         RecursiveTask<Integer> t1 = new WeighAnimalAction(weights,start,middle);
	         WeighAnimalAction t2 = new WeighAnimalAction(weights, middle, end);
	         t1.fork();
	         sum = t2.compute() +  t1.join();
//	         sum = invokeAll(t1, t2);
	        
	      }
	      return sum;
	   }
}
