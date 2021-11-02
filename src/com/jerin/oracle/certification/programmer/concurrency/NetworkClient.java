package com.jerin.oracle.certification.programmer.concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NetworkClient {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		callSerial();
//		callParallel();
		callUsingCallable();
		
		
	}
	
	public static void callUsingCallable() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		ExecutorService es = Executors.newCachedThreadPool();
		setup();
		Future<String> res1 =  es.submit(new NetworkClientCallable(6000));
		Future<String> res2 =es.submit(new NetworkClientCallable(6001));
		Future<String> res3 =es.submit(new NetworkClientCallable(6002));
		Future<String> res4 =es.submit(new NetworkClientCallable(6003));
		
		es.shutdown();
		System.out.println(es.awaitTermination(3, TimeUnit.SECONDS));
		System.out.println("B4 get");
//		res1.get();
//		res2.get();
//		res3.get();
//		res4.get();
		
		
		System.out.println(res1.get());
		System.out.println(res2.get());
		System.out.println(res3.get());
		System.out.println(res4.get());
		
		System.out.println("Time for callable " + (System.currentTimeMillis() - start));
	}
	
	public static void callParallel() {
		setup();
		ExecutorService es  = Executors.newCachedThreadPool();
		es.execute(() ->callSerial(5, 6000 ));
		es.execute(() ->callSerial(5, 6001 ));
		es.execute(() ->callSerial(5, 6002 ));
		es.execute(() ->callSerial(5, 6003 ));
		es.shutdown();
	}
	
	public static void callSerial() {
		long start = System.currentTimeMillis();
	
		setup();
		callSerial(5, 6000);
		callSerial(5, 6001);
		callSerial(5, 6002);
		callSerial(5, 6003);
		System.out.println("Time for serial " + (System.currentTimeMillis() - start));
	}
	
	public static void setup() {
		ExecutorService es  = Executors.newCachedThreadPool();
		es.execute(() -> {NetworkServer.startServer(6000);});
		es.execute(() -> {NetworkServer.startServer(6001);});
		es.execute(() -> {NetworkServer.startServer(6002);});
		es.execute(() -> {NetworkServer.startServer(6003);});
		
		es.shutdown();
	}
	
	public static void getResponse() {
		
	}

	public static void callSerial(int times, int port) {

		try (Socket ss = new Socket("localhost", port);
				DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
				DataInputStream dis = new DataInputStream(ss.getInputStream());) {

			
			for (int i= 0; i<times; i++) {
				dout.writeUTF(i+"");
			}
			dout.writeUTF("-1");
			dout.flush();
			
			
			String ip = dis.readUTF();
			while (!ip.equals("-1")) {
//				System.out.println(ip);
				ip = dis.readUTF();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
