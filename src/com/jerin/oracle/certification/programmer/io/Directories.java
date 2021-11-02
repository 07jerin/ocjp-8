package com.jerin.oracle.certification.programmer.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Directories {
	
	public static void main(String[] args) throws IOException {
		String dirPath = IOFiles.fileNamePrefix + "subdir";
		File dir = new File(dirPath);
		dir.mkdir();
		
		File file = new File( dir, "subfile.txt");
		file.createNewFile();
		try(PrintWriter pw = new PrintWriter(file)){
			pw.print("Hello");
			pw.println();
			pw.print("World");
		}
		
		file.renameTo(new File (dir, "newSubfile.txt"));
		System.out.println("Trying to delete dir " +dir.delete());
		
		String newDirPath = IOFiles.fileNamePrefix + "newSubdir";
		File newDir = new File(newDirPath);
		dir.renameTo(newDir);
		
//		dir = new File(newDirPath);
		System.out.println(Arrays.toString(newDir.list()));
	}

}
