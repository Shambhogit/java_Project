package com.Microproject;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEmployee {
	
	public Scanner sc = new Scanner (System.in);
	public Connection connection = null;
	public void insertEmployee() {
		try {
			//loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//making connection 
			String url = "jdbc:mysql://localhost:3306/jdbcdb";
			String user = "root";
			String password = "shambho@2003";
			connection = DriverManager.getConnection(url,user,password);
			//sql qurey to execute
			String sql = "insert into employee (empName,dateOfJoining,department,salary) values (?,?,?,?) ";
			PreparedStatement pstat = connection.prepareStatement(sql);
			
			//taking user input for name date department salary 
			int salary ;
			String name,date,department;
			
			System.out.println("Enter the name of Employee: ");
			name = sc.nextLine();
			
			System.out.println("Enter the joining date of Employee");
			System.out.println("Please Enter date in form of (dd/mm/yyyy)");
			date = sc.next();
			
			System.out.println("Enter the Department of Employee: ");
			department = sc.next();
			
			System.out.println("Enter the salary of Employee: ");
			salary = sc.nextInt();
			
			pstat.setString(1, name);
			pstat.setString(2, date);
			pstat.setString(3, department);
			pstat.setInt(4, salary);
			
			int numberOfRowsAffected = pstat.executeUpdate(); // it returns number of rows affected in data base;
			if(numberOfRowsAffected >0) {
				System.out.println("Employee inserted successfully...");
				System.out.println("+--------------------------------------------------------------------------------------------+");
			}
			else {
				System.out.println("Somthing went Wrong");
				System.out.println("+--------------------------------------------------------------------------------------------+");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
