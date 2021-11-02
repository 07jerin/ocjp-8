package com.jerin.oracle.certification.programmer.io;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConsoleTry {
	public static void main(String[] args) throws IOException {

//		String line;
		Console c = System.console();
//		Writer w = c.writer();
//		if ((line = c.readLine()) != null)
//		   w.append(line);
//		
//		w.flush();
//		String col = "e";
//		 c. printf ("Your favorite color is "+col);
//		
//		deleteTree(new File("D:\\dir"));
		pullBytes(new BufferedInputStream(new FileInputStream("D:\\dir\\f1.txt")), 3);

	}

	public static String pullBytes(BufferedInputStream is, int count) throws IOException {

		is.mark(1);
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append((char) is.read());
		}

		is.reset();
		is.skip(1);
		sb.append((char) is.read());
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void deleteTree(File file) {
		if (!file.isFile())
			for (File entry : file.listFiles())
				deleteTree(entry);
		else
			file.delete();
	}


}
