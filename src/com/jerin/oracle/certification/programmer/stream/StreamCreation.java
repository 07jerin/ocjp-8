package com.jerin.oracle.certification.programmer.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.jerin.oracle.certification.common.Generators;
import com.jerin.oracle.certification.programmer.io.IOFiles;

public class StreamCreation {

	public static void main(String[] args) {
		arrays();
		collection_Stream();
		stream_of();
		files_lines();
		
		primitiveStreams();
		

	}

	private static void primitiveStreams() {
		IntStream is = IntStream.of(1, 2, 3);
		DoubleStream ds = DoubleStream.of(1, 2, 3);

		Integer[] arr = { 1, 2, 3 };
		int[] intArr = { 1, 2, 3 };
		
		Stream<Integer> s = Arrays.stream(arr);
//		Stream<Integer> stI = Arrays.stream(intArr); // If it is intArray then it creates IntStream and not Stream of Integers
		IntStream is1 = Arrays.stream(intArr);
	}

	private static void files_lines() {
		System.out.println();
		try (Stream<String> linesStream = Files.lines(Paths.get(IOFiles.fileNamePrefix + "sample1.txt"))) {
			linesStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void stream_of() {
		System.out.println();
		long gt1 = Stream.of(1, 2, 3).filter(i -> i > 1).count();
		System.out.println("Stream of GT1 " + gt1);

		Stream<Employee> es = Stream.of(new Employee(), new Employee("Jerin", 0, 0));
		System.out.println("es size : " + es.count());

		Integer[] arr = { 1, 2, 3 };
		Stream<Integer> arrS = Stream.of(arr); // can use of in array as well var args

		List<Integer> ls = Arrays.asList(1, 2, 3);
//		Stream<Integer> listS = Stream.of(ls); // can use of in list 
	}

	private static void collection_Stream() {
		System.out.println();

		List<Integer> ls = Arrays.asList(1, 2, 3);
		long lgt1 = ls.stream().filter(i -> i > 1).count();
		System.out.println("List GT1 " + lgt1);

		Map<Integer, String> map = Generators.getMap();
		long mpGT1 = map.entrySet() // stream is available only on Set and not on map
				.stream().filter(es -> es.getKey() > 1).count();
		System.out.println("Map GT1 " + mpGT1);
	}

	private static void arrays() {
		Integer[] arr = { 1, 2, 3 };
		Stream<Integer> s = Arrays.stream(arr);
		long gt1 = s.filter(i -> i > 1).count();
		System.out.println("GT1 " + gt1);

		s = Arrays.stream(arr); // Need to create stream again after the terminal operation
		Stream<Integer> gt2Stream = s.filter(i -> i > 2);
		System.out.println("GT2 " + gt2Stream.count());
		
		
		
	}

}
