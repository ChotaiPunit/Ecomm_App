package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ecommerse";
		String dbUserName = "root";
		String dbPassword = "root";
		
		boolean success = false;
		
		try {
			Class.forName(driverName);
			
			Connection con = DriverManager.getConnection(url,dbUserName,dbPassword);
			PreparedStatement pstmt = con.prepareStatement("select * from ecom where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				success = true;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (success) {
			response.sendRedirect("Home.jsp");
		} else {
			request.setAttribute("error", "Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	}
	
}
