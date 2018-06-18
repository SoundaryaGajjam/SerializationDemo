package com.scp.serialization;

import java.io.*;

public class KeywordsDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		A obj=new A(10,20,30,100);
		File file=new File("pqr.txt");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		System.out.println("Serialization completed...");
		
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		A newObj=(A) ois.readObject();
		ois.close();
		System.out.println(newObj);
		System.out.println("Deserialization completed...");
		
		
	}
}
class A implements Serializable{
	int i;
	int j;
	transient int k;
	static transient String name="Smith";
	final transient String game="Tennis";
	static transient String city;
	final transient int x;
	final static transient int y=600;
	static{
		//y=200;
		z=300;
		city="Pune";
	}
	final static transient int z;
	
	public A(int i, int j,int k,int x) {
		super();
		this.i = i;
		this.j = j;
		this.k=k;
		this.x=x;
	}

	@Override
	public String toString() {
		return "A [i=" + i + ", j=" + j + ", k=" + k + ",name=" + name + ", game=" + game + ",city=" + city + ", x=" + x+ ", y=" + y+ ", z=" + z + "]";
	}
}

/*output

Serialization completed...
A [i=10, j=20, k=0,name=Smith, game=Tennis, x=0, y=600, z=300]
Deserialization completed...*/


