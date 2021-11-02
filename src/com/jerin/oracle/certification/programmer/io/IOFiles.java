package com.jerin.oracle.certification.programmer.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.jerin.oracle.certification.common.PrintUtil;

public class IOFiles {
	public static final String fileNamePrefix = "D:\\Jerin\\git\\OracleUniversityJavaCertification\\src\\com\\jerin\\oracle\\certification\\programmer\\io\\";

	public static void main(String[] args) throws IOException {
		writeFromConsoleToFile();
		PrintUtil.spacer();
		writeFromFileToConsole();
	}

	private static void writeFromConsoleToFile() throws IOException {
		System.out.println("Enter values to save to file , and q to finish");
		String file1 = fileNamePrefix + "sample1.txt";
		try (BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
				BufferedWriter bw = new BufferedWriter(new FileWriter(file1))) {
			while (true) {
				String ip = br.readLine();
				if ("q".equalsIgnoreCase(ip)) {
					break;
				} else {
					bw.write(ip);
					bw.newLine();
				}
			}
			bw.flush();
		}
	}

	private static void writeFromFileToConsole() throws FileNotFoundException, IOException {
		String file1 = fileNamePrefix + "sample1.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(file1));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			while (true) {
				String ip = br.readLine();
				if (ip == null) {
					break;
				} else {
					bw.write(ip);
					bw.newLine();
				}
			}
			bw.flush();
		}
	}

}
