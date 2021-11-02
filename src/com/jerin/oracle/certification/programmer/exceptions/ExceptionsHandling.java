package com.jerin.oracle.certification.programmer.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionsHandling {
	
	public static void main(String[] args) {
		

		
		
	}


	private static void samples(String[] args) {
		try {
		System.out.println(args[0]);
		}catch (NullPointerException | ArithmeticException e) {
//		}catch (NullPointerException | ArithmeticException | Exception e) { The exception NullPointerException is already caught by the alternative Exception compilation error
			System.out.println("In first catch");
		}catch (Exception e) {
			System.out.println("In second catch");
		}
//		catch (ArrayIndexOutOfBoundsException e) { unreachable code compilation error
//			// TODO: handle exception
//		}
		
		System.out.println("-----No arg constructor--------");
		try {
			reader();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----Just Message constructor--------");
		
		try {
			reader1();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------Message and throwable constructor-------");
		try {
			reader2();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("------Just throwable constructor-------");
		try {
			reader3();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void reader() throws IOException, MyException{
		
	
			
	}


	private static void reader3() throws MyException {
		try(BufferedReader br = new BufferedReader(new FileReader("not-present.txt"))){
			br.read();
		}catch (IOException e) {
			throw new MyException(e);
		}
	}


	private static void reader2() throws MyException {
		try(BufferedReader br = new BufferedReader(new FileReader("not-present.txt"))){
			br.read();
		}catch (IOException e) {
			throw new MyException("My exception message", e);
		}
	}


	private static void reader1() throws MyException {
		try(BufferedReader br = new BufferedReader(new FileReader("not-present.txt"))){
			br.read();
		}catch (IOException e) {
			throw new MyException("My exception message");
		}
	}

}
