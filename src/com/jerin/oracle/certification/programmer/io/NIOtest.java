package com.jerin.oracle.certification.programmer.io;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOtest {
	

		 public static void main(String[] args) {
			 Stream<String> s = Stream.of("speak", "bark", "meow", "growl");
			 Map<String, String> map = s.collect(Collectors.toMap(m -> m+"1", k -> k));
			 System.out.println(map);
//			 System.out.println(map.size() + " " + map.get("1"));
		}
		 
		 
		 public void m() {
			 
			  class innr{
				 
			 }
		 }

}
