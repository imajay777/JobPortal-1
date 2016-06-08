package edu.fit.cis.finalproject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Auth() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String eAddress, pass;
		eAddress = request.getParameter("emailAddress").toString();
		pass = request.getParameter("password").toString();

		Connection con = null;
		Statement stmt = null;
		try {
			DatabaseUtility dbUtility = new DatabaseUtility();
			con = dbUtility.getConnection();
			stmt = con.createStatement();

			String selectSql = "select emailAddress, userType, firstName, lastName from jobapplicanttable where emailAddress = '"
					+ eAddress
					+ "'and password = '"
					+ PasswordUtility.getEncrypt(pass) + "'";
			ResultSet rs = stmt.executeQuery(selectSql);

			if (rs.next()) {
				String userType = rs.getString("userType");
				String name = rs.getString("firstName") +" "+ rs.getString("lastName");
				String emailAddress = rs.getString("emailAddress");
				HttpSession sessionvar = request.getSession();
		        sessionvar.setAttribute("name", name);
				sessionvar.setAttribute("userType", userType);
				sessionvar.setAttribute("emailAddress", emailAddress);
				if("admin".equalsIgnoreCase(userType)) {
					response.sendRedirect("secureAdmin/admin.jsp");
				} else if ("user".equalsIgnoreCase(userType)){
					response.sendRedirect("secureUser/user.jsp");
				}
			} else
				response.sendRedirect("error.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					con.close();
			} catch (SQLException e) {
			}// do nothing
		}
	}
}
