package com.jerin.oracle.certification.programmer.concurrency;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {

	public static void startServer(int port) {

		try (ServerSocket ss = new ServerSocket(port);
				Socket s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dout = new DataOutputStream(s.getOutputStream())) {

			String str = "";

			while (!str.equals("-1")) {
				str = (String) dis.readUTF();

				for (int i = 0; i < 100000; i++) {
					String temp = new String("sss" + i);

				}
				dout.writeUTF(port + " : " + str + " : " + Math.random() * 1000);
				dout.flush();

			}

			dout.writeUTF(str);
			dout.flush();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
