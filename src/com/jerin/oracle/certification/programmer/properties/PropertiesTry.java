package com.jerin.oracle.certification.programmer.properties;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTry {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		createProperties();
		updateProperties();

	}

	private static void updateProperties() throws IOException, FileNotFoundException {
		Properties prop = new Properties();
		try (FileInputStream fis = new FileInputStream("sample.properties");
				FileOutputStream fos = new FileOutputStream("sample1.properties")) {

			prop.load(fis);
			prop.list(System.out);

			String val1 = prop.getProperty("Key1");
			System.out.println("Key1 read from prop file : " + val1);

			prop.setProperty("Name", "Jerin");
			System.out.println("Added key Name : " + prop.getProperty("Name"));

			prop.setProperty("Key1", "Updated Value 1");
			prop.setProperty("Key2", "");

			prop.store(fos, "Data updated");
			prop.list(System.out);

		}

		try (FileOutputStream fos = new FileOutputStream("sample.properties")) {
			prop.store(fos, "Data updated in same file");
		}
	}

	private static void createProperties() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		try (FileOutputStream fos = new FileOutputStream("sample.properties")) {

			prop.setProperty("Key1", "Value1");
			prop.setProperty("Key2", "Value2");
			prop.setProperty("Key3", "Value3");
			prop.store(fos, "Initial Save");
		}
	}

}
