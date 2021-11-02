package com.jerin.oracle.certification.programmer.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
//		double d = 1l;
//		int i = 1l;
		
//		DoubleSupplier

//		DoubleSupplier s =  () -> {return 1/0;};
		
	
		
	}
}


class TicketTaker {
	   private static int AT_CAPACITY = 100;
	   public int takeTicket(int currentCount, IntUnaryOperator counter) {
	      return counter.applyAsInt(currentCount);
	   }
	   public static void main(String...theater) {
	      final TicketTaker bob = new TicketTaker();
	      final int oldCount = 50;
	      final int newCount = bob.takeTicket(oldCount,t -> {
	         if(t>AT_CAPACITY) {
	            throw new RuntimeException("Sorry, max has been reached");
	         }
	         return t+1;
	      });
	      System.out.print(newCount);
	   }
	}


 class Market {
	   private static void checkPrices(List<Double> prices,
	          Consumer<Double> scanner) {
	      prices.forEach(scanner);
	   }
	   public static void main(String[] right) {
	      List<Double> prices = Arrays.asList(1.2, 6.5, 3.0);
	      checkPrices(prices,
	            p -> {
	               String result = p<5 ? "Correct" : "Too high";
	               System.out.println(result);
	            });
	   }
	
	}
 
 
 
 