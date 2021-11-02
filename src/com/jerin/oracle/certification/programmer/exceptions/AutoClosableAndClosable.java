package com.jerin.oracle.certification.programmer.exceptions;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class AutoClosableAndClosable {

	public static void main(String[] args) {
		simpleTest();
	}



	public static void simpleTest() {

		try (A a = new A()) {

		} catch (IOException e) {
			// Catch or throws is required as close throws IOException
		}

		try (A a = new A()) {

		} catch (Exception e) {
			// Catch or throws is required as close throws IOException
		}

		try (B b = new B()) {

		} // no catch as close does not throw any exception

		try (C a = new C()) {

		} catch (Exception e) {
			// Catch or throws is required as close throws IOException
		}

		try (A a = new A(); C c = new C()) {

		} catch (IOException | SQLException e) {
			// TODO: handle exception
		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}

	}

}

class A implements Closeable {

	@Override
	public void close() throws IOException {

	}

	// Following code is fine as we can choose not to throw any exception
//	@Override
//	public void close() {
//
//	}

}

class B implements AutoCloseable {

	@Override
	public void close() {

	}

}

class C implements AutoCloseable {

	// Auto closable close overrides can throw any subclass of Exceptions
	@Override
	public void close() throws SQLException {

	}


}
