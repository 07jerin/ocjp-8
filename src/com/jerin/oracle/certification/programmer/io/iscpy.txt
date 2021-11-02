package com.jerin.oracle.certification.programmer.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.jerin.oracle.certification.common.PrintUtil;

public class BasicClasses {

	public static void main(String[] args) throws IOException {
		basicWriteRead();
		PrintUtil.spacer("File Ip/Op Stream");
		objectWriteRead();
		PrintUtil.spacer("Print Writer and Buffered Reader");
		printWriteBufferedRead();
		

	}

	private static void printWriteBufferedRead() throws IOException {
		String filePath = IOFiles.fileNamePrefix + "file2.txt";
		try (PrintWriter pw = new PrintWriter(filePath)) {
			pw.write("Hello from PW");
			pw.println();
			pw.write("World");
			pw.flush();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.lines().forEach(l -> System.out.println(l));
		}
	}

	private static void basicWriteRead() throws IOException, FileNotFoundException {
		String filePath = IOFiles.fileNamePrefix + "file1.txt";
		try (FileWriter fw = new FileWriter(filePath)) {
			fw.write("Hello \nworld");
			fw.flush();

		}

		try (FileReader fr = new FileReader(filePath)) {
			char[] in = new char[50];
			fr.read(in);
			for (char c : in) {
				System.out.print(c);
			}

		}
	}

	private static void objectWriteRead() throws IOException, FileNotFoundException {
		String objectPath = IOFiles.fileNamePrefix + "object2.txt";
		try (FileOutputStream fos = new FileOutputStream(objectPath)) {
			fos.write("Hello \nworld".getBytes("UTF-8"));
		}

		try (FileInputStream fis = new FileInputStream(objectPath)) {
			byte[] ip = new byte[50];
			int size = fis.read(ip);
			System.out.println("Number of bytes " + size);
			int i = 0;
			for (byte b : ip) {
				i++;
//				System.out.print(b);
				System.out.print((char) b);
			}
			System.out.println(i);

		}
	}

}
