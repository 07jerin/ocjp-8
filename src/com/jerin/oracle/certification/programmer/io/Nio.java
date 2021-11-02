package com.jerin.oracle.certification.programmer.io;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import com.jerin.oracle.certification.common.PrintUtil;

public class Nio {
	
	public static void main(String[] args) throws IOException {
		readFiles();
		PrintUtil.spacer();
		directories();
	}
	
	private static void readFiles() throws IOException {
		try(Stream<String> lines = Files.lines(Paths.get(IOFiles.fileNamePrefix + "sample1.txt"))){
			lines.forEach(System.out :: println);
		}
		
		
		Path file = Paths.get(IOFiles.fileNamePrefix +"sample1.txt" );
		List<String> allLines = Files.readAllLines(file);
		System.out.println(allLines);
		
		
		
	}
	
	private static void directories() throws IOException {
		System.out.println("// Print all files in current directory");
		try( Stream<Path> paths = Files.list(Paths.get("."))){
			paths.forEach(System.out :: println);
		}
			
		PrintUtil.spacer();
		
		System.out.println("// Print all Files using walk");
		try(Stream<Path> paths = Files.walk(Paths.get("."))){
			paths.forEach(System.out :: println);
		}
		
		PrintUtil.spacer();
		System.out.println("//Print only directories");
		try(Stream<Path> paths = Files.find(Paths.get("."), 10, (p, at) -> at.isDirectory(), FileVisitOption.FOLLOW_LINKS)){
			paths.forEach(System.out :: println);
		}
	}

}
