package com.jerin.oracle.certification.programmer;

public class DefaultInterfaces {
	
	public static void main(String[] args) {
		new Impl().print();
	}

}



interface ISuper{
	public default void print() {
		System.out.println("ISuper");
	}
}

interface ISub extends ISuper{
	@Override
	public default void print() {
		System.out.println("ISub");
	}
}
interface ISub1 extends ISuper{
	
}

class Impl implements ISub, ISub1{
	
}