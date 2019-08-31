package com.quinnox.jdbc;
import java.util.*;
import java.io.*;
public class SerializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		e.name ="Michael khan";
		e.address="Castle Street Banglore";
		e.ssn=11122233;
		e.number=101;
		try
		{
			FileOutputStream fileout=new FileOutputStream("d:/abc/employee.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileout);
			out.writeObject(e);
			out.close();
			fileout.close();
			System.out.println("serialized data is  saved in d:/abc/employee.ser");
		}
	 
	catch(IOException i)
	{
		i.printStackTrace();
	}
}
}