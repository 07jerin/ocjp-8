package com.jerin.oracle.certification.programmer.concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<String> {

	int port;

	public NetworkClientCallable(int port) {
		this.port = port;
	}

	@Override
	public String call() {
		String result = "";
		try (Socket ss = new Socket("localhost", port);
				DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
				DataInputStream dis = new DataInputStream(ss.getInputStream());) {

			for (int i = 0; i < 5; i++) {
				dout.writeUTF(i + "");
			}
			dout.writeUTF("-1");
			dout.flush();

			String ip = dis.readUTF();
			while (!ip.equals("-1")) {

				ip = dis.readUTF();
				result += ip;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
