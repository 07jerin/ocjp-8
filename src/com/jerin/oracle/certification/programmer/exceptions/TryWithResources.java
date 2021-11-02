package com.jerin.oracle.certification.programmer.exceptions;

import java.io.BufferedReader;
import java.io.IOException;

public class TryWithResources {

	// throws IO exception is required as IO exception is thrown from the close
	// method
	public static void declaringAutoclosable() throws IOException {
		// Try with resources does not need catch
		BufferedReader rd;
		try ( rd = new BufferedReader(null)) {
			rd = new BufferedReader(null);
		}

		try (BufferedReader rd = getReader()) {

		} catch (Exception e) {
			// Autoclosable are available inside try, just lile for loop variables
//			rd.close();
		}finally {
			// Autoclosable are available inside try, just lile for loop variables
//			rd.close();
		}

		try {

			BufferedReader rd = new BufferedReader(null);
		} finally {

		}

	}

	public static BufferedReader getReader() {
		return new BufferedReader(null);
	}

}

class v{
	int id;
	interface X{
		
	}
}
