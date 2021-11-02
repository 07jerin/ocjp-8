package com.jerin.oracle.certification.programmer.threads;

public class WaitNotify {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		new WaitNotify().call();
	}

	private  void call() throws InterruptedException {
		
		Worker w = new Worker();
		Runnable r = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // prevent wait before notify and then after that it waits for ever for a notify which will never come
			synchronized(w) {
				System.out.println("B4 Work :" + Thread.currentThread().getName());
				try {
//					w.wait(2000);
					w.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Work Done " + Thread.currentThread().getName());
			}
			};
			
		Thread jerin = new Thread(r, "Jerin");
		Thread staphy = new Thread(r, "Staphy");
		Thread mark = new Thread(r, "Mark");
		Thread mary = new Thread(r, "Mary");
		
		
		w.start();
		jerin.start();
		staphy.start();
		mark.start();
		mary.start();
		
	}

}


class Worker extends Thread{
	
	public void run() {
		try {
			System.out.println("In worker");
			work();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void work() throws InterruptedException {
//		for(int i=0; i< 5; i++) {
//			System.out.println("Hi from " + Thread.currentThread().getName());
//			Thread.sleep(500);
//		}
		
		synchronized (this) {
//			notifyAll();
			notify();
		}
		Thread.sleep(500);
		System.out.println("Non synced " + Thread.currentThread().getName());
		
		synchronized (this) {
			Thread.sleep(500);
			System.out.println("Finishing " + Thread.currentThread().getName());
		}
		
	}
	
}
