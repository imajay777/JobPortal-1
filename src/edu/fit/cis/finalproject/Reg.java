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

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reg() {
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
		String fName, mName, lName, eAddress, pNumber, address, pass, userType;
		fName = request.getParameter("firstName").toString();
		mName = request.getParameter("middleName").toString();
		lName = request.getParameter("lastName").toString();
		eAddress = request.getParameter("emailAddress").toString();
		pNumber = request.getParameter("phoneNumber").toString();
		address = request.getParameter("Address").toString();
		pass = request.getParameter("password").toString();
		userType = request.getParameter("userType").toString();
		
		Connection con = null;
		Statement stmt = null;
		String message = null;
		String page = ""; 
		try {
			con=new DatabaseUtility().getConnection();
			stmt = con.createStatement();
			pass = PasswordUtility.getEncrypt(pass);
			
			String insertSql = "insert into jobapplicanttable values('" + 0
					+ "','" + fName + "','" + mName + "','" + lName + "','"
					+ eAddress + "','" + pNumber + "','" + address + "'" + ",'"
					+ pass + "','" + userType +"')";
			stmt.executeUpdate(insertSql);
			

		} catch (SQLException e) {
			message = "Email address already present in database";
			page = "register.jsp";
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				String selectSql = "select * from jobapplicanttable";
				ResultSet rs = stmt.executeQuery(selectSql);
				if (stmt != null && rs.getString("userType").equalsIgnoreCase("admin"))
					page = "secureUser/user.jsp";
				else 
					page = "secureAdmin/admin.jsp";
					con.close();
			} catch (SQLException e) {
			}// do nothing
			
			request.setAttribute("message", message);
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
