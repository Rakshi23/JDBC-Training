package com.quinnox.jdbc;
import java.io.*;
import java.io.IOException;

	public class ReaderExample {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try
			{
				Reader reader = new FileReader("d:/abc/data.txt");
				int data = reader.read();
				while(data!=-1)
				{
					// -1 when stream ends
				System.out.print((char) data);
				data = reader.read();
				}
				reader.close();
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
			}
		}

	}


