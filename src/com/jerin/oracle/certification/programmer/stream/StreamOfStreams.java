package com.jerin.oracle.certification.programmer.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfStreams {
	
	public static void main(String[] args) {
//		try(Stream<String> stream = Files.lines(Paths.get(IOFiles.fileNamePrefix, "employees.txt"))){
			
//			Stream<String[]> strArrStream =  stream.map(s -> s.split(","));
//			strArrStream.forEach(System.out ::  println);
//			
//			Stream<Stream<Object>> streamOfStream = stream1.map(s -> Arrays.stream(s.split(",")));
//			streamOfStream.forEach(System.out ::  println);
			
//			Stream<String> flatStream = stream.flatMap(s -> Arrays.stream(s.split(",")));
//			flatStream.forEach(System.out :: println);
			
//			String[] p = null;
//			Stream<String> c = Arrays.stream(p);
//			
//			Stream<String> flatStream  = stream
//						.flatMap(s -> Arrays.stream(s.split(",")))
//						.flatMap(s -> Arrays.stream(s.split("/")));
//			flatStream.forEach(System.out :: println);
			
			IntStream is =  Arrays.stream(new int[]{1,2,3});
//			Stream<Integer> si = Stream.of(1,2,3);
//			Optional<Integer> red = si.reduce((a, b) -> a+b);
//			Integer red = si.reduce(1, (a, b) -> a+b);
			
			String value = "MY VERY LONG SENTANCE IS VERY VERY LONG".chars()
				.mapToObj(i -> new String("" +(char)i))
//				.parallel()
//				.collect(Collectors.toList());
				.collect(() -> new StringBuilder(), StringBuilder::append, (sb, str) -> sb.append("H" + str)  )
				.toString();
			
			System.out.println(value);
			
			
//			System.out.println(Optional.empty().get());
			Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
			Stream<String> infinite = Stream.generate(() -> "chimp");
			System.out.println(infinite.allMatch(pred)); // true
			
			Optional<Double> min =  Stream.generate(Math::random)
//			.filter(d -> d > 100)
			.limit(50)
			.max(Comparator.comparing(Double::doubleValue));
//			.collect(Collectors.toList());
			System.out.println(min.orElse(0.0));
			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
