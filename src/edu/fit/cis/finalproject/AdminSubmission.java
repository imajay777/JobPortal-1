package edu.fit.cis.finalproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminSubmission
 */
@WebServlet("/secureAdmin/AdminSubmission")
public class AdminSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSubmission() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String compName = request.getParameter("companyName").toString();
		String compNumber = request.getParameter("contactNumber").toString();
		String compAddress = request.getParameter("address").toString();
		String compLocation = request.getParameter("GlobalLocations")
				.toString();

		Connection con = null;
		Statement stmt = null;
		String insertSqlComp = "insert into `companytable`"
				+ "(`companyName`, `contactNumber`, `address`, `GlobalLocations`) values "
				+ "(?,?,?,?)";

		try {
			con = new DatabaseUtility().getConnection();
			PreparedStatement statementComp = con
					.prepareStatement(insertSqlComp);

			stmt = con.createStatement();

			statementComp.setString(1, compName);
			statementComp.setString(2, compNumber);
			statementComp.setString(3, compAddress);
			statementComp.setString(4, compLocation);

			statementComp.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					con.close();
			} catch (SQLException e) {
			}// do nothing

			request.getRequestDispatcher("/secureAdmin/adminPartTwo.jsp")
					.forward(request, response);
		}

	}

}
