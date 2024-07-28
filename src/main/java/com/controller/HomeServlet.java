package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String qty = request.getParameter("qty");
		String productImagePath = request.getParameter("productImagePath");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerse", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("insert into products (productName ,price ,category ,qty ,productImagePath ) values (?,?,?,?,?)");

			pstmt.setString(1, productName);
			pstmt.setString(2, price);
			pstmt.setString(3, category);
			pstmt.setString(4, qty);
			pstmt.setString(5, productImagePath);

			int record = pstmt.executeUpdate();// insert

			System.out.println(record + " Inserted");
			
			response.sendRedirect("Home.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
