package com.jerin.oracle.certification.programmer.main;

public class InnerClassTest {

	Printer sample = new Printer() {

		@Override
		public void print() {
			System.out.println("Sample Printer");

		}
	};

	Printer sample2 = new Printer() { // These create new class files

		@Override
		public void print() {
			System.out.println("Sample2 Printer");

		}
	};

	public static void main(String[] args) {
		InnerClassTest obj = new InnerClassTest();
		obj.print(obj.sample);
		obj.print(obj.sample2);
		obj.print(new Printer() {// These create new class files

			@Override
			public void print() {
				System.out.println("Mehod level inner class");

			}
		});

		Printer lambdaObj = () -> System.out.println("Lambda Variable");
		obj.print(lambdaObj);

		obj.print(() -> System.out.println("Lambda 1"));
		obj.print(() -> System.out.println("Lambda 2"));
		obj.print(() -> System.out.println("Lambda 3"));
	}

	public void print(Printer p) {
		p.print();
	}

}
