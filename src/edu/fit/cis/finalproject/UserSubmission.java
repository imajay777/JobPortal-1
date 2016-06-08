package edu.fit.cis.finalproject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class userSubmiss
 */
@WebServlet("/secureUser/UserSubmission")
@MultipartConfig(maxFileSize = 16177215)
public class UserSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSubmission() {
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
		HttpSession session = request.getSession(true);
		String eAddress = session.getAttribute("emailAddress").toString();
		String cLetter = request.getParameter("coverLetter").toString();
		String tSkills = request.getParameter("techSkills").toString();
		String ntSkills = request.getParameter("nonTechSkills").toString();
		InputStream inputStream = null; // input stream of the upload file

		// obtains the upload file part in this multipart request

		Part filePart = request.getPart("resume");
		if (filePart != null) {
			// prints out some information for debugging

			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file

			inputStream = filePart.getInputStream();
		}

		Connection con = null;
		Statement stmt = null;
		String insertSqlDoc = "insert into `jobapplicantdoctable`"
				+ "(`jobApplicantId`, `resume`, `coverLetter`) values "
				+ "(?,?,?)";

		String insertSqlSkill = "insert into `jobapplicantresumetable` "
				+ "(`jobApplicantId`, `technicalSkills`, `nonTechnicalSkills`) values"
				+ "(?,?,?)";
		try {
			con = new DatabaseUtility().getConnection();
			PreparedStatement statementDoc = con.prepareStatement(insertSqlDoc);
			PreparedStatement statementSkills = con
					.prepareStatement(insertSqlSkill);
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT jobApplicantId FROM jobapplicanttable where emailAddress = '"
							+ eAddress + "'");
			rs.next();
			int applicantId = rs.getInt(1);

			// For insertion of documents in doc table

			statementDoc.setInt(1, applicantId);
			if (inputStream != null) {

				// fetches input stream of the upload file for the blob column

				statementDoc.setBlob(2, inputStream);
			}
			statementDoc.setString(3, cLetter);

			// For insertion of skills in skill table

			statementSkills.setInt(1, applicantId);
			statementSkills.setString(2, tSkills);
			statementSkills.setString(3, ntSkills);
			statementDoc.executeUpdate();
			statementSkills.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/success.jsp").forward(request,
					response);
		}
	}
}
