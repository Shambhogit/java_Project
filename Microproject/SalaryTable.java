package com.Microproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SalaryTable {
	Connection connection = null;
	public void showTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbcdb";
			String user = "root";
			String password = "shambho@2003";
			
			connection = DriverManager.getConnection(url,user,password);
			
			Statement statement = connection.createStatement();
			String sql = "select * from salary";
			ResultSet result = statement.executeQuery(sql);
			
			
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s","date of pay","basicSalary","HRA","TravalAllowance", "incomeTax","professionalTax","grosspay","empId","empName");
			 System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------+");
			while (result.next()) {
				System.out.printf("%-13s %-9d %-15d %-12d %-14d %-10d %-11d %-8d %-10s",result.getString(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getInt(5),result.getInt(6),result.getInt(7),result.getInt(8),result.getString(9));
				System.out.println();
			}
			 System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
