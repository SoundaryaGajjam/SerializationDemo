package com.scp.serialization;

import java.io.*;

public class ExternalizableDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Mobile obj=new Mobile("iPhone", 1111, 81000);
		File file=new File("abc.txt");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		System.out.println("Serialization completed....");
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Mobile newObj=(Mobile) ois.readObject();
		ois.close();
		System.out.println(newObj);
		System.out.println("Deserialization completed...");
		
	}
}
class Mobile implements Externalizable{
	String mobName;
	int mobIMEINo;
	double mobPrice;
	public Mobile() {
		super();
		System.out.println("Default constructor");
	}
	public Mobile(String mobName, int mobIMEINo, double mobPrice) {
		super();
		this.mobName = mobName;
		this.mobIMEINo = mobIMEINo;
		this.mobPrice = mobPrice;
		System.out.println("Para constructor");
	}
	@Override
	public String toString() {
		return "Mobile [mobName=" + mobName + ", mobIMEINo=" + mobIMEINo + ", mobPrice=" + mobPrice + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(mobName);
		out.writeInt(mobIMEINo);
		out.writeDouble(mobPrice);
		
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		mobName=(String) in.readObject();
		mobIMEINo=in.readInt();
		mobPrice=in.readDouble();
		
	}
	
}
