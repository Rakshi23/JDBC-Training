package com.quinnox.jdbc;
import java.sql.*;
import java.util.Scanner;

public class UpdateDemo {
	
	
	public static void main(String[] args) {
		Connection con;
		int cnt = 0;
		ResultSet rs;
		PreparedStatement pstmt;
		String sqlUpdate;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","rh");
			sqlUpdate = "UPDATE employees "+ "SET job_id =?"+ "WHERE employee_id =?";
			pstmt = con.prepareStatement(sqlUpdate);
			
			///prepare data for update
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Employee Id:");
			int eid = s.nextInt();
			s.nextLine();
			System.out.println("Enter Job Title:");
			String strm = s.nextLine(); //Sales Manager
			
			pstmt.setString(1, strm);
			pstmt.setInt(2, eid);
			
			int rowAffected = pstmt.executeUpdate();
			System.out.println("Row affected"+ rowAffected);
			
				//reuse the prepared statement
			strm = "AC_MGR";
			eid = 205;
			pstmt.setString(1, strm);
			pstmt.setInt(2, eid);
			
			rowAffected = pstmt.executeUpdate();
			System.out.println("Row affected" +rowAffected);
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
