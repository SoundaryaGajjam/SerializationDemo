package com.scp.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestDeserialization {
	public static void main(String[] args) throws IOException {
		FileInputStream fis;
		ObjectInputStream ois=null;
		File file=new File("abc.txt");
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			Student st2=(Student) ois.readObject();
			System.out.println(st2);
			System.out.println("Deserialization completed...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ois.close();
		}
		
		
	}

}
