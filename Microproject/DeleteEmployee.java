package com.Microproject;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Scanner;


public class DeleteEmployee {
	public Connection connection = null;
	public Scanner sc = new Scanner(System.in);
	public void deleteEmployee() {
	System.out.println("Enter the Employee ID : ");
	int Id = Integer.parseInt(sc.next());
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//making connection 
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String user = "root";
		String password = "shambho@2003";
		connection = DriverManager.getConnection(url,user,password);
		
		String sql = "delete from employee where empId = "+Id;
		
		PreparedStatement prstat = connection.prepareStatement(sql);
		
		int row = prstat.executeUpdate();
		
		if(row>0) {
			System.out.println("Record Deleted Successefully ");
			System.out.println("+--------------------------------------------------------------------------------------------+");
		}
		else {
			System.out.println("No such Record Exist");
			System.out.println("+--------------------------------------------------------------------------------------------+");
		}
		
	}
	catch(Exception e) {
		System.out.println (e);
	}
	}
}
