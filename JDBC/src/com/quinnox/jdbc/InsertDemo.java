package com.quinnox.jdbc;
import java.sql.*;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
		int cnt = 0;
		ResultSet rs;
		Statement stmt;
		
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","rh");
				stmt = con.createStatement();
				rs = stmt.executeQuery("select*from employees");

				String str = "DELETE FROM LOCATIONS WHERE CITY='Sydney'";
				
					stmt = con.createStatement();
					int rowcount = stmt.executeUpdate(str);
					if(rowcount>0)
					{
						System.out.println("Records Deleted Successfully");
					}
					else
					{
						System.out.println("Error");
					}
			
			String str1 = "select count(location_id)from locations";
			rs = stmt.executeQuery(str1);
			while(rs.next())
			{
				cnt = rs.getInt(1);
			}
			System.out.println("Total no. of records is: "+cnt);
			con.close();
		}
		
		catch(Exception ce)
		{
			System.out.println(ce);
		}
		

	}
}
	
