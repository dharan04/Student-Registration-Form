package com.hari;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String college = request.getParameter("college");
		String branch = request.getParameter("branch");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Registration successful</h1>");
		out.println("</body>");
		out.println("</html>");
		
		String insertedItem = "INSERT INTO studentInfo(username, rollno, college, branch) VALUES(?, ?, ?, ?);";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "mysql")) {

			
			PreparedStatement pst = con.prepareStatement(insertedItem);
			pst.setString(1, name);
			pst.setInt(2, rollno);
			pst.setString(3, college);
			pst.setString(4, branch);
       	    pst.executeUpdate();
			
		} catch (SQLException e) {
            // process  exception
            e.printStackTrace();
    	}
	}

}
