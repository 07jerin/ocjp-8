package com.jerin.oracle.certification.programmer.io.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.jerin.oracle.certification.programmer.io.IOFiles;

public class BasicSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		basicSerialization();
	}

	private static void basicSerialization() throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(new File(IOFiles.fileNamePrefix + "/serialization/cat.ser")))) {
			Cat c = new Cat();
			c.color = "Black";
			c.name = "Blacky";
			c.tag = "AXMN";
			c.age = 5;
			c.id = 2000;
			c.tid = 2000;
			oos.writeObject(c);
		}

		System.out.println("Starting deserialization");
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(new File(IOFiles.fileNamePrefix + "/serialization/cat.ser")))) {
			Cat c = (Cat) ois.readObject();
			System.out.println(c.name + " - " + c.color + " : " + c.tag + ", age : " + c.age + ",  ten : " + c.ten
					+ ", animal id : " + c.id + " animal tid : " + c.tid);
		}
	}

}

class Cat extends Animal implements Serializable {

	Animal a = new Animal();
	public Cat() {
		System.out.println("In cat constructor");
	}

	String color = "Red";
	transient String name = "Default";
	transient String tag;
	transient int age;
	transient int ten = 10;

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		name = (String) (ois.readObject());
		ois.defaultReadObject();
		age = ois.readInt();
		tag = (String) (ois.readObject());
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(name);
		oos.defaultWriteObject();
		oos.writeInt(age);
		oos.writeObject(tag);
	}

}

class Animal {//implements Serializable {

	public int id = 1000;
	public transient int tid = 1000;

	public Animal() {
		System.out.println("In Animal Constructor");
	}

}
