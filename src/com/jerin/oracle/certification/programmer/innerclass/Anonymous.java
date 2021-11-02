package com.jerin.oracle.certification.programmer.innerclass;

public class Anonymous {

	public static void main(String[] args) {
		simpleAnonymousFromClass();
		simpleAnonymousFromInterface();
		
		argumentAnalnymousInner();
		
		
	}

	private static void argumentAnalnymousInner() {
		System.out.println();
		
		printMe(new IPrinter() {
			
			@Override
			public void print2() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void print() {
			 System.out.println("Argument impl");
				
			}
		});
	}
	
	private static void printMe(IPrinter p) {
		p.print();
	}

	private static void simpleAnonymousFromInterface() {
		IPrinter p = new IPrinter() {
			public void print() {
				System.out.println("Anonymous Print");
			}

			void newPrintMethod() { // Can declare new method, but cant use it !
				System.out.println("Anonymous newPrintMethod");
			}

			@Override
			public void print2() { // This should be added as we are creating for interface
				// TODO Auto-generated method stub

			}
		};

		p.print();
		p.print2();
//		p.newPrintMethod(); // Error as the Printer super class cant see the method in the anonymous sub class 
	}

	private static void simpleAnonymousFromClass() {
		Printer p = new Printer() {
			void print() {
				System.out.println("Anonymous Print");
			}

			void newPrintMethod() { // Can declare new method, but cant use it !
				System.out.println("Anonymous newPrintMethod");
			}
		};

		p.print();
		p.print2();
//		p.newPrintMethod(); // Error as the Printer super class cant see the method in the anonymous sub class 
	}

}

interface IPrinter {

	void print();

	void print2();
}

class Printer {
	public Printer() {
		System.out.println("COns");
	}

	void print() {
		System.out.println("Print");
	}

	void print2() {
		System.out.println("Print2");
	}
}
