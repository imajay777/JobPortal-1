package edu.fit.cis.finalproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminSubmissionPartTwo
 */
@WebServlet("/secureAdmin/AdminSubmissionPartTwo")
public class AdminSubmissionPartTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSubmissionPartTwo() {
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

		String jobTitle = request.getParameter("jobTitle").toString();
		String jobDesc = request.getParameter("jobDescription").toString();
		String jobRequire = request.getParameter("requirements").toString();

		Connection con = null;
		Statement stmt = null;

		String insertSqlPost = "insert into `jobpostingtable` "
				+ "(`companyId`, `jobTitle`, `jobDesc`, `requirements`) values"
				+ "(?,?,?,?)";

		try {
			con = new DatabaseUtility().getConnection();
			PreparedStatement statementPost = con
					.prepareStatement(insertSqlPost);
			stmt = con.createStatement();

			stmt.executeQuery("SET FOREIGN_KEY_CHECKS=0");

			ResultSet rs = stmt
					.executeQuery("SELECT `companyId` FROM `companytable` where `companyName` = '"
							+ compName + "'");
			rs.next();
			int companyId = rs.getInt(1);

			statementPost.setInt(1, companyId);
			statementPost.setString(2, jobTitle);
			statementPost.setString(3, jobDesc);
			statementPost.setString(4, jobRequire);

			statementPost.executeUpdate();

			stmt.executeQuery("SET FOREIGN_KEY_CHECKS=1");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					con.close();
			} catch (SQLException e) {
			}

			request.getRequestDispatcher("/success.jsp").forward(request,
					response);
		}
	}

}
