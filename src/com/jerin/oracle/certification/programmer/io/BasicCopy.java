package com.jerin.oracle.certification.programmer.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class BasicCopy {
	public static void main(String[] args) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(IOFiles.fileNamePrefix + "is.txt"));
				BufferedReader br = new BufferedReader(new FileReader(IOFiles.fileNamePrefix + "iscpy.txt"))) {

			
			char[] buf = new char[1024];
			int size = 0;
//			while ((size = br.read(buf)) > 0){ 
//				bw.write(buf, 0, size);
//				bw.flush();
//			}
			
			System.out.println(br.read());
			System.out.println(br.read());
			System.out.println(br.read());

		}
		
		try (FileInputStream is = new FileInputStream(IOFiles.fileNamePrefix + "is.txt")) {
//			is.read
		}
		
		FileReader fr;
		

	}
}
