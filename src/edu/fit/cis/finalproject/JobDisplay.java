package edu.fit.cis.finalproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JobDisplay
 */
@WebServlet("/JobDisplay")
public class JobDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    Connection con = null;
		Statement stmt = null;

	    try {
	        
	        con = new DatabaseUtility().getConnection();
	        System.out.println("Connected!");

	        ArrayList<String> aljobTitle = null;
	        ArrayList<String> aljobDesc = null;
	        ArrayList<String> al`requirements` = null;
	        ArrayList<ArrayList<String>> jobTitle = new ArrayList<ArrayList<String>>();
	        ArrayList<ArrayList<String>> jobDesc = new ArrayList<ArrayList<String>>();
	        String query = "select * from `jobpostingtable`";

	        System.out.println("query " + query);
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {

	            aljobTitle = new ArrayList<String>();

	            out.println(rs.getString(2));
	            out.println(rs.getString(3));
	            out.println(rs.getString(4));
	            out.println(rs.getString(5));

	            al.add(rs.getString(2));
	            al.add(rs.getString(3));
	            al.add(rs.getString(4));
	            al.add(rs.getString(5));


	            System.out.println("aljobTitle :: " + aljobTitle);
	            jobTitle.add(aljobTitle);
	        }


	        request.setAttribute("jobTitle", jobTitle);
	        RequestDispatcher view = request.getRequestDispatcher("/searchview.jsp");
	        view.forward(request, response);
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
