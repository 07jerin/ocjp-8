package com.jerin.oracle.certification.programmer.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Sum extends RecursiveAction { // line n1
	static int THRESHOLD_SIZE = 3;
	int stIndex, lstIndex;
	int[] data;

	public Sum(int[] data, int start, int end) {
		this.data = data;
		this.stIndex = start;
		this.lstIndex = end;
		 this.THRESHOLD_SIZE = 10;
	}

	protected void compute() {
		int sum = 0;
		if (lstIndex - stIndex <= THRESHOLD_SIZE) {
			for (int i = stIndex; i < lstIndex; i++) {
				sum += data[i];
			}
			System.out.println(sum + " " + Thread.currentThread().getName());
		} else {
			new Sum(data, stIndex + THRESHOLD_SIZE, lstIndex).fork();
			new Sum(data, stIndex, Math.min(lstIndex, stIndex + THRESHOLD_SIZE)).compute();
			System.out.println("CP,[;eye");
		}
	}

	public static void main(String[] args) {
		ForkJoinPool fjPool = new ForkJoinPool();
		int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		fjPool.invoke(new Sum(data, 0, data.length));
	}
}

class FileThread implements Runnable {
	String fName;

	public FileThread(String fName) {
		this.fName = fName;
	}

	public void run () { System.out.println(fName);}

	public static void main(String[] args) throws IOException, InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Stream<Path> listOfFiles = Files.walk(Paths.get("Java Projects"));
		listOfFiles.forEach(line -> {
			executor.execute(new FileThread(line.getFileName().toString())); //

		});
		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.DAYS); // line n2
	}
}

