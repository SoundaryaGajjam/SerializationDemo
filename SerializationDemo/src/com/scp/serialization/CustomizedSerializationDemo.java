package com.scp.serialization;

import java.io.*;
public class CustomizedSerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		GmailAccount obj=new GmailAccount("Smith","Mumbai");
		
		File file=new File("pqr.txt");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(obj);
		System.out.println(obj);
		System.out.println("Serialization Completed...");
		oos.close();
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
		GmailAccount newObj=(GmailAccount) ois.readObject();
		System.out.println(newObj);
		System.out.println("Deserialization Completed...");
		ois.close();
	}
}
class GmailAccount implements Serializable{
	String userName;
	transient String password;
	public GmailAccount(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "\nGmailAccount [userName=" + userName + ", password=" + password + "]";
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.defaultWriteObject();
		 password="1234"+password;
		oos.writeObject(password);
		
	}
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		ois.defaultReadObject();
		password=(String)ois.readObject();
		 password=password.substring(4);
		 
		 
	}
}
