package com.Microproject;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Display {
	Connection connection = null;
	
	public void displayData() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String user = "root";
		String password = "shambho@2003";
		
		connection = DriverManager.getConnection(url,user,password);
		
		Statement statement = connection.createStatement();
		
		String sql = "select * from employee";
		ResultSet result = statement.executeQuery(sql);
		
		System.out.printf("%-10s %-20s %-15s %-15s %-13s","EmpId","EmpName","DateOfJoining","Department", "salary");
		 System.out.println("\n+----------------------------------------------------------------------------------------------+");
		while (result.next()) {
			System.out.printf("%-10d %-20s %-15s %-15s %-15d",result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5));
			System.out.println();
		}
		 System.out.println("+----------------------------------------------------------------------------------------------+");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
