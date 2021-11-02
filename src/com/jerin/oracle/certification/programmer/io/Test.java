package com.jerin.oracle.certification.programmer.io;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test implements Serializable {
	
	public class T1{

	 
	}
	
	   public static void main(String[] audio) throws Exception {
		   
		  Map<Integer, Integer> i = new HashMap<Integer, Integer>();
		  i.put(1, 1);
		  i.put(2, null);
		  i.put(3, 3);
		  
//		  i.merge(5, 100, (v1, v2) -> {System.out.println("Inserting ... "); return null;});
//		  Integer r = i.putIfAbsent(5, 100);
		  Integer r = i.computeIfPresent(2, (k,v) ->  {System.out.println("Inserting ... "); return null;});
//		  Integer r = i.computeIfAbsent(1, (k) ->  {System.out.println("Inserting ... "); return null;});
		  
		  System.out.println(r);
		  System.out.println(i);

	   }
}
	
