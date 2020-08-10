package main.java;
import java.sql.*;  
public class LoginDao {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
			if((name.equalsIgnoreCase("s38959")&&pass.equalsIgnoreCase("abc@123")) || (name.equalsIgnoreCase("s38958")&&pass.equalsIgnoreCase("xyz@123")))
				return true;
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		  Connection con = DriverManager.getConnection("jdbc:mysql://mysqldb:3306/demoapp?"
		  + "user=root&password=root@123");
		 
		/*
		 * Connection con =
		 * DriverManager.getConnection("jdbc:mysql://localhost/demoapp?" +
		 * "user=root&password=root@123");
		 */
		/*
		 * Connection con=DriverManager.getConnection(
		 * "jdbc:mysql://mysqldb:33060/demoapp","dbusr","root@123");
		 */ 
		System.out.println("Database connection successful");
		PreparedStatement ps=con.prepareStatement(  
		"select * from login where username=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);
		
		System.out.println("Database connection failed");}  
		return status;  
		}  
}
