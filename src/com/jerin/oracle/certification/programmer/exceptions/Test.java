package com.jerin.oracle.certification.programmer.exceptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;

public class Test {

	private int x = 10;
	private AtomicInteger a = new AtomicInteger(x);

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {

//		olfMain();
		
		try {
			
		}catch (ArithmeticException e) {
			// TODO: handle Exexception
		}
	}

	private static void olfMain() throws IOException, FileNotFoundException {
		Test t = new Test() {
			void Test() {

			}
		};
//		addAndPrintItems(new LinkedBlockingDeque());

//		t2();
		pullBytes(new BufferedInputStream(new FileInputStream("D:\\dir\\f1.txt")), 3);
//		System.out.println(test());
	}

	public static void test() {

	}

	public static String pullBytes(BufferedInputStream is, int count) throws IOException {

		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append((char) is.read());
		}
		is.mark(1);
		sb.append((char) is.read());
		sb.append((char) is.read());
		sb.append((char) is.read());
		sb.append((char) is.read());
		sb.append((char) is.read());

		is.reset();
		is.skip(1);
		sb.append((char) is.read());
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void addAndPrintItems(BlockingDeque<Integer> deque) throws InterruptedException {
		deque.offer(103);
		deque.offerFirst(20, 1, TimeUnit.SECONDS);
		deque.offerLast(85, 7, TimeUnit.HOURS);
		System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
		System.out.print(" " + deque.pollLast(1, TimeUnit.MINUTES));
	}

	public static void t2() {
		ExecutorService service = Executors.newFixedThreadPool(1);
		DoubleStream.of(3.14159, 2.71828) // b1
				.forEach(c -> service.submit( // b2
						() -> System.out.println(10 * c))); // b3
		service.execute(() -> System.out.println("Printed")); // b4

		service.shutdown();
	}

	static class test implements AutoCloseable {

		@Override
		public void close() throws Exception {
			throw new Exception("Auto");

		}

	}

	public static void testname() throws Exception {

	}

	interface x {

	}

}
