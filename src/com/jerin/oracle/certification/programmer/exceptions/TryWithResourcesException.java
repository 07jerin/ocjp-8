package com.jerin.oracle.certification.programmer.exceptions;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class TryWithResourcesException {

}
 class StuckTurkeyCage implements AutoCloseable {
	   public void close() throws Exception  {
	     throw new SQLException("Cage door does not close");
	   }
	   public static void main(String[] args) throws Exception {
	      try (StuckTurkeyCage t = new StuckTurkeyCage()) { // DOES NOT COMPILE
	         System.out.println("put turkeys in");
	         throw new RuntimeException("RTE0");
	      }catch (SQLException e) {
	    	  System.out.println("in Catch");
	    	  System.out.println(e);
	    	  for(Throwable f :  e.getSuppressed()) {
	    		  System.out.println(f.getClass() + f.toString());
	    	  }
	    	  
		}
	      
	   }
	}