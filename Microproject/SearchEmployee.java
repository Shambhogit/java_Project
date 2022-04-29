package com.Microproject;

import java.util.Scanner;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class SearchEmployee {
	public Connection connection = null;
	public Scanner sc = new Scanner(System.in);
	
	public void searchEmployee() {
	
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String user = "root";
		String password = "shambho@2003";
		
		connection = DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("PRESS 1 TO SEARCH");
		System.out.println("PRESS 2 TO PAY");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the name of Employee ");
			String name = sc.next();
			try {
			String sql = "select * from employee where empName = '"+name+"'";
			Statement statement = connection.createStatement();
		    ResultSet result = statement.executeQuery(sql);
		    while(result.next()) {
		    int id = result.getInt("empId");
		    String dataName = result.getString("empName");
		    String date = result.getString("dateOfJoining");
		    String dept = result.getString("department");	
		    int sal = result.getInt("salary");
		    
		    System.out.println("ID of empolyee is                 : "+id);
		    System.out.println("NAME of empolyee is               : "+dataName);
		    System.out.println("DATE OF JOINING of empolyee is    : "+date);
		    System.out.println("DEPARTMANET of empolyee is        : "+dept);
		    System.out.println("SALARY of empolyee is             : "+sal);
		    System.out.println("+----------------------------------------------------------------------------------------------+"); 
		    }
			}
			catch(Exception e) {
				System.out.println(e);
			}
			break;
		case 2:
			System.out.println("Enter the id of Employee ");
			int getid = sc.nextInt();
			try {
			String sql = "select * from employee where empId = "+getid;
			Statement statement = connection.createStatement();
		    ResultSet result = statement.executeQuery(sql);
		    
		    while(result.next()) {
			    int id = result.getInt("empId");
			    String dataName = result.getString("empName");
			    String date = result.getString("dateOfJoining");
			    String dept = result.getString("department");	
			    int sal = result.getInt("salary");
			    
			    System.out.println("ID of empolyee is                 : "+id);
			    System.out.println("NAME of empolyee is               : "+dataName);
			    System.out.println("DATE OF JOINING of empolyee is    : "+date);
			    System.out.println("DEPARTMANET of empolyee is        : "+dept);
			    System.out.println("SALARY of empolyee is             : "+sal);
			    System.out.println("+----------------------------------------------------------------------------------------------+");
		    
		    System.out.println("DO YOU WANT TO PAY SALARY TO THIS EMPLOYEE");
		    System.out.println("PRESS 1 TO PAY");
		    System.out.println("PRESS 2 TO CANCEL");
		    int ch = sc.nextInt();
		   
		    if(ch == 1) {
//		    	to get date
		    	 LocalDate localDate = LocalDate.now();
		         String nowDate = localDate.toString();
		         
		         int basicSalary = sal;
		         
		         int hra = (basicSalary/100)*5;
		         
		         int TA = (basicSalary/100)*6;
		         
		         int total = basicSalary + hra + TA;
		         int incomeTax;
		         if(basicSalary >= 50000) {
		             incomeTax = (total/100)*7; 
		         }
		         else {
		        	 incomeTax = (total/100)*5;
		         }
		         
		         int professionalTax = (total/100)*7;
		         
		         int grosspay= total-incomeTax-professionalTax;
		         
		         Connection connection2 = null;
		        try { 
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		 		
		        	String url = "jdbc:mysql://localhost:3306/jdbcdb";
		        	String user = "root";
		        	String password = "shambho@2003";
		 		
		        	connection2 = DriverManager.getConnection(url,user,password);
		        	
		        	String sqlsal = "insert into salary (dateOfPay,basicSalary,HRA,travalAllowance,incomeTax,professionTax,grosspay,empId,empName) values (?,?,?,?,?,?,?,?,?)";
		        	
		        	PreparedStatement st = connection2.prepareStatement(sqlsal);
		        	st.setString(1, nowDate);
		        	st.setInt(2, basicSalary);
		        	st.setInt(3, hra);
		        	st.setInt(4, TA);
		        	st.setInt(5, incomeTax);
		        	st.setInt(6, professionalTax);
		        	st.setInt(7, grosspay);
		        	st.setInt(8, id);
		        	st.setString(9, dataName);
		        	
		        	int row1 = st.executeUpdate();
		        	
		        		if(row1>0) {
		        			System.out.println("+--------------------------------------------------------------------------------------------+");
		        			System.out.println("Date                          :"+nowDate);
		        			System.out.println("Basic Salary                  :"+basicSalary);
		        			System.out.println("HRA                           :"+hra);
		        			System.out.println("Traval Allownce               :"+TA);
		        			System.out.println("Income Tax                    :"+incomeTax);
		        			System.out.println("Professional Tax              :"+professionalTax);
		        			System.out.println("Gross Pay(Total Payment)      :"+grosspay);
		        			System.out.println("+--------------------------------------------------------------------------------------------+");
		        			System.out.println("Pyament Successfull....");
		        			System.out.println("+--------------------------------------------------------------------------------------------+");

		        		}
		        		else {
		        			System.out.println("Not able to Pay");
		        		}
		        	
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
		         
		    }
		    else {
		    	
		    }
		    }
			}
			catch(Exception e) {
				System.out.println(e);
			}
			break;
		default:
			System.out.println("\nEnter the valide choice\n");
			break;
		}
	}

}
