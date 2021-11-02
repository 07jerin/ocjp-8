package com.jerin.oracle.certification.programmer.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Optionals {

	public static void main(String[] args) {
		simpleOptionals();

		primitiveOpionals();

		customOptionalOperations();

	}

	private static void simpleOptionals() {
		Stream<Integer> streamInteger = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> opI = streamInteger.findFirst();
		System.out.println(opI.get());
		opI.isPresent();
		opI.ifPresent(System.out::println);
//		opI.ifPresentOrElse(i -> System.out.println(i), () -> System.out.println("No value"));
	}

	private static void primitiveOpionals() {
		System.out.println("INt Stream");
		IntStream is = IntStream.of(1, 2, 3, 4, 5);
		OptionalInt opInt = is.findFirst();
		System.out.println(opInt.getAsInt());
		opInt.isPresent();
		opInt.ifPresent(System.out::println);
//		opInt.ifPresentOrElse(i -> System.out.println(i), () -> System.out.println("No value"));
	}

	private static void customOptionalOperations() {
		System.out.println("Custom Optional");
		Employee jerin = new Employee("Jerin", 0, 0);
		Employee nullE = null;
		Optional<Employee> opJerinE = Optional.of(jerin);
//		Optional<Employee> opNullE = Optional.of(nullE); // NPE
		Optional<Employee> opNullE = Optional.ofNullable(nullE);
//		opJerinE.ifPresentOrElse(i -> System.out.println(i), () -> System.out.println("No value"));
//		opNullE.ifPresentOrElse(i -> System.out.println(i), () -> System.out.println("No value"));
		
		System.out.print("Or else ");
		Optional<Employee> empty = Optional.empty();
		Employee e = empty.orElse(jerin);
		System.out.println(e);
	}

}
