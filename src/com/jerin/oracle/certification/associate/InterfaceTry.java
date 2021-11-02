package com.jerin.oracle.certification.associate;

import java.util.Comparator;

public class InterfaceTry {
	
	public static void p(Object o) {
		System.out.println("Object");
	}
	public static void p(long	 o) {
		Impl im = new subImpl();
		System.out.println(im.name);
		subImpl im1 = new subImpl();
		System.out.println(new subImpl().name);
	}
//	public static void p(Integer o) {	
//		System.out.println("Integer");
//	}
	
	public static void p(Long o) {
		System.out.println("Long");
	}
	
	public static void main(String[] args) {
		int x = 1;
		p(x);
	}
	
	public float x (int y) {
		return y/5;
	}
	

	
}

interface IA{
	default void print(){
		System.out.println("IA");
	}
}

interface IB{
		default void print(){
			System.out.println("IB");
//			return "";
		}
}

interface IC extends IA, IB{

	@Override
	default void print() {
		// TODO Auto-generated method stub
		IA.super.print();
	}

//	@Override
//	default String print() {
//		// TODO Auto-generated method stub
//		IA.super.print();
//	}
}

interface Itest {
	@Override
	boolean equals(Object obj);

	void test();
}

class Impl implements Itest, Comparator<String> {

	String name = "IMpl";
	Impl(String s){
		
	}
	
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		X1 x = () -> t1(); 
	}
	
	public int t1() {
		return 1;
	}
	
	public void t2() {
		
	}
	


}

interface X1{
	int test();
}

class subImpl extends Impl implements Itest {
//	String name = "subImpl";
	public subImpl() {
		// TODO Auto-generated constructor stub
		
		super("");
//		System.out.println("Jerin");
	}

}