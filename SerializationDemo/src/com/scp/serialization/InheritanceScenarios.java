package com.scp.serialization;

import java.io.*;

public class InheritanceScenarios {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Parent Pobj=new Parent(10);
		Child CObj=new Child(100, 200);
		File file=new File("pqr.txt");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		//oos.writeObject(Pobj);
		oos.writeObject(CObj);
		System.out.println("Serialization completed ....");
		oos.close();
		
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		//Parent newPObj=(Parent) ois.readObject();
		//System.out.println(newPObj);
		
		Child newCObj=(Child) ois.readObject();
		System.out.println(newCObj);
		System.out.println("Deserialization Completed ....");
		ois.close();
		
		
	}
}
class Parent {
	int x;
	public Parent(){
		
	}
	public Parent(int x) {
		super();
		this.x = x;
	}
	@Override
	public String toString() {
		return "Parent [x=" + x + "]";
	}
	
}
class Child extends Parent implements Serializable{
	int y;

	public Child(int x, int y) {
		super(x);
		this.y = y;
	}

	@Override
	public String toString() {
		return "Child [x=" + x + ", y=" + y + "]";
	}
	
}
