package edu.fit.cis.finalproject;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtility {

	public Connection getConnection()
	{
		String url = "jdbc:mysql://jobportal:12345/jobportal"; // "jdbc:mysql://<HOST_NAME>:<PORT_NUMBER>/jobportal"
		String username = "abc"; //DB_USERNAME
		String password = "password"; //DB_PASSWORD
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
