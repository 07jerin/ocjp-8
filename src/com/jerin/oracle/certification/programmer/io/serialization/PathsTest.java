package com.jerin.oracle.certification.programmer.io.serialization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.stream.Stream;

import com.jerin.oracle.certification.programmer.concurrency.Atomic;
import com.jerin.oracle.certification.programmer.io.IOFiles;

enum Continent {
	ASIA, EUROPE
}

public class PathsTest {
	int cost = 2;

	int getCost() {
		return cost;
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		BufferedReader br = new BufferedReader(new FileReader(IOFiles.fileNamePrefix+ "is.txt"));
		System.out.println(br.markSupported());
	}
	

}

interface Moveable<Integer> {
	public default void walk(Integer distance) {
		System.out.println("Walking");
	}

	public void run(Integer distance);
}
