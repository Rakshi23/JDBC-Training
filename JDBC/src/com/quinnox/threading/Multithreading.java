package com.quinnox.threading;

class MulthithreadingDemo extends Thread
{
	public void run()
	{
		try
		{
		System.out.println("thread "+Thread.currentThread().getId()+" is running");
		}
		catch(Exception e)
		{
			System.out.println("exception is caught");
		}
	}
}
public class Multithreading {
public static void main(String[] args){
	int n=18;
	for(int i=0;i<n;i++){
		MulthithreadingDemo obj=new MulthithreadingDemo();
		obj.start();
	}
}
}
