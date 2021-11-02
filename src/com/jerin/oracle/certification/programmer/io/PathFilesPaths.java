package com.jerin.oracle.certification.programmer.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.DriverManager;
import java.sql.SQLWarning;

public class PathFilesPaths {

	public static void main(String[] args) throws IOException {
		BasicFileAttributes attributes = Files.readAttributes(null, BasicFileAttributes.class);
		BasicFileAttributeView attributea = Files.getFileAttributeView(null, BasicFileAttributeView.class);

		final Path path = Paths.get("../OracleUniversityJavaCertification").normalize(); // h1
		System.out.println(path.toAbsolutePath());
		System.out.println(path);
		System.out.println(path.getParent());
		int count = 0;
		for (int i = 0; i < path.getNameCount(); ++i) {
			count++;
		}
		System.out.println(count);

	}

	public static void createSymbolicLink(Path target) throws IOException {
		Path link = Paths.get(".", "symbolic_link.txt");
		if (Files.exists(link)) {
			Files.delete(link);
		}
		Files.createSymbolicLink(link, target);
	}

	private static void createDirectoyCopyFiles() throws IOException {
		Path base = Paths.get("sub/sub1");
		String innerFile = base.toString() + "/innerFile.txt";
		if (Files.notExists(base)) {
			Files.createDirectories(base);
		}

//		
		Path innerFilePath = Paths.get(innerFile);
//		Files.deleteIfExists(innerFilePath);
//		Files.createFile(innerFilePath);

		Files.list(base).forEach(System.out::println);

		Path base2 = Paths.get("copySub/sub1");
		if (Files.notExists(base2)) {
			Files.createDirectories(base2);
		}
		Path newFileLocation = Paths.get(base2.toString() + "/newFile.txt");
//		Files.move(innerFilePath, newFileLocation, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(innerFilePath, newFileLocation, StandardCopyOption.REPLACE_EXISTING);

		Files.list(base2).forEach(System.out::println);
	}

	private static void basicFileCreation() throws IOException {
		Path file1 = Paths.get(IOFiles.fileNamePrefix, "file1.txt");
		System.out.println("Is Absolute file : " + file1.isAbsolute());
		System.out.println("Is File exist " + Files.exists(file1));

		Path file2 = Paths.get("fileX.txt");
		System.out.println("Is Absolute file : " + file2.isAbsolute());
		System.out.println("Is File exist " + Files.exists(file2));
//		if(Files.exists(file2)) {
//			Files.delete(file2);
//		}
		Files.deleteIfExists(file2);
		Files.createFile(file2);
		System.out.println(Files.exists(file2));
	}

}
