package com.quinnox.jdbc;
import java.util.Scanner;
import java.sql.*;

public class Colleges{
	 
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet res;
	Colleges()
	{
		con=null;
	}
	
	public Connection getConnection()
	{
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");//registering the driver
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","varunky","pass");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public void insertCollege(String cname, String courcetype, String city,double fees,int pin) {
	try {
			con = getConnection();
		    ps = con.prepareStatement("insert into college values"
		    		+ "(college_id.NEXTVAL,?,?,?,?,?)");
		    ps.setString(1, cname);
		    ps.setString(2, courcetype);
		    ps.setString(3, city);
		    ps.setDouble(4, fees);
		    ps.setInt(5, pin);
		   
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("Inserted");
		    } else {
		        System.out.println("not Inserted");
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		
		}
	
	public void getCollege() 
	{
	  try {
	   con = getConnection();
	   st = con.createStatement();
	   res = st.executeQuery("select * from college where city='Mumbai' and coursetype='Engg'");
	   System.out.println("cid\t CollegeName\t CourceType \t\t City \t\t Fees \t\t Pincode");
	   System.out.println("--------------------------------------------------------------------------------------------");
	  while (res.next()) 
	  {
	    System.out.print(res.getInt(1)+"\t ");
	    System.out.print(res.getString(2)+"\t\t ");
	    System.out.print(res.getString(3)+" \t\t ");
	    System.out.print(res.getString(4)+" \t\t ");
	    System.out.print(res.getDouble(5)+" \t\t ");
	    System.out.println(res.getInt(6));
	  }
	  System.out.println("-------------------------------------------------------------------------------------------------");
	  res.close();
	  con.close();
	  } 
	  catch (Exception e) 
	  {
	  System.out.println("Error in fetching data" + e);
	  }
	}
	void getCollegebycity(String city){
		try {
			con = getConnection();
		    ps = con.prepareStatement("select * from college where city=?");
		    ps.setString(1, city);
		   
		   
		    res = ps.executeQuery();
		    
		    System.out.println("cid\t CollegeName\t CourceType \t\t City \t\t Fees \t\t Pincode");
			   System.out.println("--------------------------------------------------------------------------------------------");
			  while (res.next()) 
			  {
			    System.out.print(res.getInt(1)+"\t ");
			    System.out.print(res.getString(2)+"\t\t ");
			    System.out.print(res.getString(3)+" \t\t ");
			    System.out.print(res.getString(4)+" \t\t ");
			    System.out.print(res.getDouble(5)+" \t\t ");
			    System.out.println(res.getInt(6));
			  }
			  System.out.println("-------------------------------------------------------------------------------------------------");
			  res.close();
			  con.close();
		    
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	public void updateCollege(Double fee,String college) 
	{
		try {
			 con = getConnection();
		    ps = con.prepareStatement("update college"
		    		+ " set fees=? where cname=?");
		    ps.setDouble(1, fee);
		    ps.setString(2,college);
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("Cource fees updated");
		    } else {
		        System.out.println("not updated");
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public void deleteCollege(int cid) 
	{
		try {
			con = getConnection();
		    ps = con.prepareStatement("delete from college where cid=?");
		    ps.setInt(1, cid);
		    int i = ps.executeUpdate();
		    if (i != 0) {
		        System.out.println("College deleted");
		    } else {
		        System.out.println("College Doesn't Exist");
		    }
		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Colleges c=new Colleges();
		String city;
		int cid;
		
		System.out.println("************** Global Tech Solutions **************");
		System.out.println("----------- Customer Management System ----------");
		while(true)
		{
		System.out.println("Press 1 for Insert College \t Press 2 to Display Engg clg in Mumbai");
		System.out.println("Press 3 to Display Colleges by city \t Press 4 to Update Cource fees");
		System.out.println("5 to Delete Customer\t\tPress 6 for Exit"); 
			
		Scanner s=new Scanner(System.in);
		int option=s.nextInt();
		
		switch(option)
		{
		case 1: System.out.println("Enter College Name,CourceType, City ,Fees & Pincode :");
		        String name=s.next();
		        String courcetype=s.next();
		        city=s.next();
		        Double fees=s.nextDouble();
		        int pin=s.nextInt();
			c.insertCollege(name,courcetype,city,fees,pin);
			break;
		case 2: c.getCollege();
				break;
		case 3: System.out.println("Enter City to Display Colleges:");
				city=s.next();
				c.getCollegebycity(city);
				break;
		case 4: System.out.println("Enter Courcefees & college name to be Updated:");
        		Double fee=s.nextDouble();
        		String college=s.next();
        		c.updateCollege(fee, college);
        		break;
		case 5: System.out.println("Enter CollegeId  to be Deleted:");
				cid=s.nextInt();
				c.deleteCollege(cid);
				break;
		case 6: System.out.println("Program Terminated");
		 	System.exit(0);
		
		default: System.out.println("Invalid Selection");
		          break;
		}
		
		
		}
	}

}
