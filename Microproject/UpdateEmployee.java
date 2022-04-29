package com.Microproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UpdateEmployee {
	
	public Scanner sc = new Scanner(System.in);
	public Connection connection = null;
	
	public void update() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbcdb";
			String user = "root";
			String password = "shambho@2003";
			connection = DriverManager.getConnection(url,user,password);
			
			System.out.println("Enter the ID of Employee : ");
			int id = sc.nextInt();
			
			Statement statement = connection.createStatement();
			String sql = "Select * from employee where empId = "+id;
			ResultSet result = statement.executeQuery(sql);
			
				System.out.printf("%-10s %-20s %-15s %-15s %-13s","EmpId","EmpName","DateOfJoining","Department", "salary");
			    System.out.println("\n+----------------------------------------------------------------------------------------------+");
				while (result.next()) {
					System.out.printf("%-10d %-20s %-15s %-15s %-15d",result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5));
					System.out.println();
				}
				System.out.println("+----------------------------------------------------------------------------------------------+");
				
				
				
				System.out.println("WHAT DO YOU WANT TO UPDATE");
				System.out.println("PRESS 1 TO UPDATE NAME");
				System.out.println("PRESS 2 TO UPDATE DATE OF JOINING");
				System.out.println("PRESS 3 TO UPDATE DEPARTMENT");
				System.out.println("PRESS 4 TO UPDATE SALARY");
				int choice = sc.nextInt();
				
				String sqlqri;
				PreparedStatement prstat;
				int row;
				
				switch(choice) {
				case 1:
					System.out.println("Enter new Name of Employee");
					String name = sc.next();
					
					sqlqri = "update employee set empName = '"+name +"' where empId = "+id; 
					prstat = connection.prepareStatement(sqlqri);
					row = prstat.executeUpdate();
					if(row>0) {
						System.out.println("UPDATE SUCCESSEFULL ....");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					else {
						System.out.println("SOMTING WENT WRONG !!!");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					break;
				case 2:
					System.out.println("Enter new date of joining of Employee");
					System.out.println("Please Enter date in form of (dd/mm/yyyy)");
					String date = sc.next();
					
					sqlqri = "update employee set dateOfJoining = '"+date +"' where empId = "+id; 
					prstat = connection.prepareStatement(sqlqri);
					row = prstat.executeUpdate();
					if(row>0) {
						System.out.println("UPDATE SUCCESSEFULL ....");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					else {
						System.out.println("SOMTING WENT WRONG !!!");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					break;
				case 3:
					System.out.println("Enter new Department of Employee");
					String dept = sc.next();
					
					sqlqri = "update employee set department = '"+dept +"' where empId = "+id; 
					prstat = connection.prepareStatement(sqlqri);
					row = prstat.executeUpdate();
					if(row>0) {
						System.out.println("UPDATE SUCCESSEFULL ....");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					else {
						System.out.println("SOMTING WENT WRONG !!!");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					break;
				case 4:
					System.out.println("Enter new Salary of Employee");
					int salary = sc.nextInt();
					
					sqlqri = "update employee set salary = "+salary +" where empId = "+id; 
					prstat = connection.prepareStatement(sqlqri);
					row = prstat.executeUpdate();
					if(row>0) {
						System.out.println("UPDATE SUCCESSEFULL ....");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					else {
						System.out.println("SOMTING WENT WRONG !!!");
						System.out.println("+----------------------------------------------------------------------------------------------+"); 
					}
					break;
				default:
					System.out.println("ENTER VALIDE CHOICE PLEASE");
					break;
						
				}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
