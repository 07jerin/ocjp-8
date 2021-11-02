package com.jerin.oracle.certification.programmer.threads;

public class Syncronization {

	public static void main(String[] args) {
//		synchronizationMethod();
		synchronizationBlock();

	}
	
	private synchronized static void testStaticSync(){
		synchronized (Account.class) {
			
		}
//		synchronized (this) { // this not available in  static
//			
//		}
		
		synchronized (new Account()) {
			
		}
	}

	private static void synchronizationMethod() {
		Account ac = new Account();

		Runnable r = new Runnable() {

			private synchronized boolean checkAndWithDraw() {

				int balance = ac.check();
				System.out.println("Check by " + Thread.currentThread().getName() + balance);
				try {
					Thread.sleep(3 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (balance >= 10) {
					System.out.println("Withdrawal by " + Thread.currentThread().getName() + balance);
					ac.withdraw(10);
					return true;
				}
				return false;
			}

			@Override
			public void run() {
				boolean hasBalance = true;
				while (hasBalance) {
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					hasBalance = checkAndWithDraw();
				}
			}
		};

		Thread mary = new Thread(r, "Mary");
		Thread george = new Thread(r, "George");

		mary.start();
		george.start();
	}

	private static void synchronizationBlock() {
		Account ac = new Account();

		Runnable r = new Runnable() {

			private boolean checkAndWithDraw() {


				synchronized (new Account()) {
					System.out.println("Synced by new objects " + Thread.currentThread().getName());
					synchronized (Syncronization.class) {
//						synchronized (this) {
//						synchronized (ac) {
						int balance = ac.check();
						System.out.println("Check by " + Thread.currentThread().getName() + balance);
						try {
							Thread.sleep(1 * 1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (balance >= 10) {
							System.out.println("Withdrawal by " + Thread.currentThread().getName() + balance);
							ac.withdraw(10);
							return true;
						}
						return false;
					}
				}
			}

			@Override
			public void run() {
				boolean hasBalance = true;
				while (hasBalance) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					hasBalance = checkAndWithDraw();
				}
			}
		};

		Thread mary = new Thread(r, "Mary");
		Thread george = new Thread(r, "George");

		mary.start();
		george.start();
	}

}

class Account {
	int amount = 50;

	public int check() {
		return amount;
	}

	public void withdraw(int value) {
		amount = amount - value;
		if (amount < 0) {
			System.out.println("Account overdrawn ! by " + Thread.currentThread().getName());
		}
	}
}
