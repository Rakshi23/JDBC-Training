package com.quinnox.jdbc;
import java.sql.*;
import java.sql.DriverManager;

public class Classabledemo {

		// TODO Auto-generated method stub
		Connection con;
		CallableStatement cstmt;
		ResultSet rs;
		Classabledemo()
		{
			
		}
	public	void createConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","rh");
	
	}catch(Exception e){
		System.out.println(e);
	}
	}	
		public void addDept(){
			try
			{
				cstmt=con.prepareCall("{call adjust_salary(100,10)}");
				
				int cnt=cstmt.executeUpdate();
				if(cnt>0)
				{
					System.out.println("salary updated");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	
		public static void main(String[] args) {
			Classabledemo cd1=new Classabledemo();
			cd1.createConnection();
			cd1.addDept();
}
}