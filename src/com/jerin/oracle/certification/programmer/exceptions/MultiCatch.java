package com.jerin.oracle.certification.programmer.exceptions;

import java.awt.FontFormatException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiCatch {
	
	public void test() throws SQLException, IOException {
		try {
			DriverManager.getConnection("");
			throw new IOException("Test");
		}catch (SQLException | IOException e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) throws SQLException, IOException, FontFormatException {
		testCatchException();
	}
	
	public static  void testCatchException() throws SQLException, IOException, FontFormatException {
		
		try {
			throwsSQLIOException();
			throwsCatchedException();
			
		}catch (Exception  e) {
			System.out.println("In catch");
//			throw new AgentLoadException();
//			e = new IOException();
			throw e;
		}
	}
	
	public static void throwsSQLIOException() throws SQLException, IOException {
		Integer one = null;
		one.toString();
	}
	
	public static void throwsCatchedException() throws FontFormatException{
		
	} 

}
