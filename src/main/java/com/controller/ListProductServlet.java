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

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet{

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerse", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("select * from products");
			
			ResultSet rs = pstmt.executeQuery();
			request.setAttribute("rs", rs);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListProduct.jsp");
			rd.forward(request, response);
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
