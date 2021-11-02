package com.jerin.oracle.certification.programmer.exceptions;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class TryWIthResourcesCodeFlow {
	public static void main(String[] args) {
		codeFlowAndSuppressedExceptions();
	}

	public static void codeFlowAndSuppressedExceptions() {
		try (A1 a = new A1(); B1 b = new B1(); C1 c = new C1()) {
			System.out.println("In try block");
//			c.causeError();
		} catch (IOException | SQLException e) {
			System.out.println(e.getMessage());
			for (Throwable tw : e.getSuppressed()) {
				System.out.println("Suppressed : " + tw.getMessage());
			}
		} finally {
			System.out.println("In finally");
		}

	}

}

class A1 implements Closeable {

	public A1() {
	}

	@Override
	public void close() throws IOException {
		System.out.println("close A");
		throw new IOException("IO exception from A");
	}

}

class B1 implements AutoCloseable {

	public B1() {
//		throw new RuntimeException("Error from B1 conastructor");
	}

	@Override
	public void close() throws IOException {
		System.out.println("close B");
		throw new RuntimeException("Runtime exception from B :: close");
//		throw new IOException("IO exception from B");
	}

}

class C1 implements AutoCloseable {

	@Override
	public void close() throws SQLException {
		System.out.println("close C");
		throw new SQLException("SQL exception from C");
	}

	public void causeError() {
		throw new RuntimeException("Error from C");
	}

}
