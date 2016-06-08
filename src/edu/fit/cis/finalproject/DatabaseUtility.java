package edu.fit.cis.finalproject;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtility {

	public Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/jobportal";
		String username = "root";
		String password = "";
		Connection con = null;

		try 
		{
			con = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
