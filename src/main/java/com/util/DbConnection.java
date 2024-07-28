package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc::mysql://localhost:3306/ecommerse", "root", "root");
			
			System.out.println(con);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
