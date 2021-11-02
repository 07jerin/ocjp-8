package com.jerin.oracle.certification.programmer.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.UnaryOperator;

import com.jerin.oracle.certification.common.Generators;

public class Functions {

	public static void main(String[] args) {

//		mapFunctions();
//
//		unaryAndPrimitives();
		
		BiFunction<String, String, String> combinator = String :: concat;
		System.out.println(combinator.apply("Jerin ", "Joseph"));

	}

	private static void unaryAndPrimitives() {
		System.out.println();
		IntToDoubleFunction i2d = i -> i * 1.3;
		DoubleToIntFunction d2i = d -> (int) d;

		System.out.println(i2d.applyAsDouble(2));
		System.out.println(d2i.applyAsInt(3.224));

		UnaryOperator<Integer> square = i -> i * i;
		System.out.println(square.apply(3));

		UnaryOperator<Integer> root = i -> (int) Math.sqrt(i);

		System.out.println(square.andThen(root).apply(6));
	}

	private static void mapFunctions() {
		Function<Integer, String> f1 = i -> "New Value" + i.toString();
		BiFunction<Integer, String, String> bif1 = (i, s) -> i + " Bi func --> " + s.toUpperCase();

		Map<Integer, String> map = Generators.getMap();

		map.computeIfAbsent(5, (k) -> "Five");
		map.computeIfAbsent(5, (k) -> "Five");

		map.forEach((k, v) -> System.out.println(k + ":" + v));

		map.replaceAll((k, v) -> k + " -- " + v.toUpperCase());
		System.out.println();
		map.forEach((k, v) -> System.out.println(k + ":" + v));

		map.computeIfAbsent(6, f1);
		System.out.println();
		map.forEach((k, v) -> System.out.println(k + ":" + v));

		map.replaceAll(bif1);
		System.out.println();
		map.forEach((k, v) -> System.out.println(k + ":" + v));
	}

//	IntToLong
//	DOubletoInt
//	
//	UnaryOperator
}
