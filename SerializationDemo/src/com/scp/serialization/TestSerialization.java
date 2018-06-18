package com.scp.serialization;

import java.io.*;

public class TestSerialization {
	public static void main(String[] args) throws IOException   {
		Student st1=new Student(10, "John",9876543210L);
		
		File file=new File("abc.txt");
		FileOutputStream fos;
		ObjectOutputStream oos=null;
		try {
			 fos=new FileOutputStream(file);
			 oos=new ObjectOutputStream(fos);
			oos.writeObject(st1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			oos.close();
		}
		System.out.println("Serialization Completed...");
		
	}
}
class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int studId;
	private String studName;
	transient private long mobNo;
	int i;
	public Student(int studId, String studName,long mobNo) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.mobNo=mobNo;
		i=100;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName+ ", Mobile No=" + mobNo +", i=" + i+ "]";
	}
	
	
}
