package com.jerin.oracle.certification.programmer.io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.jerin.oracle.certification.common.PrintUtil;

public class DirectoryStreamFileVisitior {

	public static void main(String[] args) throws IOException {
		directoryStream();

		PrintUtil.spacer("Walk File Tree");
		Files.walkFileTree(Paths.get("./"), new TxtFilePrinterIncludingSubDirectories());
		
		PrintUtil.spacer("Using Glob");
		Files.walkFileTree(Paths.get("./"), new TxtFilePrinterInBinUsingGlob());

	}

	private static void directoryStream() throws IOException {
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get("./"))) {
			ds.forEach(p -> {
				if (p.toString().endsWith(".txt")) {
					System.out.println(p);
				}
			});
		}
	}

}


class TxtFilePrinterInBinUsingGlob extends SimpleFileVisitor<Path> {
	
	PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/bin/**.txt");

	public FileVisitResult visitFile(Path path, BasicFileAttributes ba) {

		if (matcher.matches(path)) {
			System.out.println(path);
		}
		return FileVisitResult.CONTINUE;
	}

}

class TxtFilePrinterIncludingSubDirectories extends SimpleFileVisitor<Path> {

	public FileVisitResult visitFile(Path file, BasicFileAttributes ba) {

		if (file.getFileName().toString().endsWith(".txt")) {
			System.out.println(file);
		}
		return FileVisitResult.CONTINUE;
	}

}