package com.jerin.oracle.certification.programmer.lambda;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {

	public static void main(String[] args) {
		
		 Arrays.asList(1,2,3,4).stream()
         .forEach(System.out::println);
      Arrays.asList(1,2,3,4).parallelStream()
         .forEachOrdered(System.out::println);
      
      Callable c = new Callable() {
    	   public Object run() {return 10;}

		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
    	};
		 
	}

}


class Riddle {
	   public void sleep() {
	      try {
	         Thread.sleep(5000);
	      } catch (Exception e) {}
	   }
	   public String getQuestion(Riddle r) {
	      synchronized(this) {
	         sleep();
	         if(r != null) r.getAnswer(null);
	         return "How many programmers does it take "
	               + "to change a light bulb?";
	      }
	   }
	   public synchronized String getAnswer(Riddle r) {
	      sleep();
	      if(r != null) r.getAnswer(null);
	      return "None, that's a hardware problem";
	   }
	 
	   public static void main(String... ununused) {
		   
		
	      final Riddle r1 = new Riddle();
	      final Riddle r2 = new Riddle();
	      
//	      Runnable r = () ->  r1.getAnswer(r);
	      ExecutorService s = Executors.newFixedThreadPool(2);
	      s.submit(() -> r1.getAnswer(r2));
	      s.execute(() -> r2.getAnswer(r1));
	      s.execute(() -> r2.getAnswer(r1));
	      s.shutdown();
	   }
	}
