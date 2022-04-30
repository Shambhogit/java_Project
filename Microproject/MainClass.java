package com.Microproject;

import java.util.Scanner;

public class MainClass {
	private static String admin1 = "system";
	private static String pass1 = "ritp1227";
	
	private static String admin2 = "shambho";
	private static String pass2 = "shambho@2003";
	
	private static String admin3 = "mandar";
	private static String pass3 = "mandar@2002";
	
	private static String admin4 = "prathamesh";
	private static String pass4 = "prathamesh@2004";
	

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		// ask for user name 
		System.out.println("+----------------------------------------------------------------------------------------------+"); 
		System.out.println("Enter the userName : ");
		String userName = sc.next();
		
		//ask for password
		System.out.println("Enter the password : ");
		String password = sc.next();
		System.out.println("+----------------------------------------------------------------------------------------------+"); 
		
		if(admin1.equals(userName) && pass1.equals(password)||admin2.equals(userName) && pass2.equals(password)||admin3.equals(userName) && pass3.equals(password)||admin4.equals(userName) && pass4.equals(password)) {
			System.out.println("Your Loged in Successfully...");
			System.out.println("Welcome to System : "+userName);
			System.out.println("+----------------------------------------------------------------------------------------------+"); 

			SwitchClass switchClass = new SwitchClass();
			switchClass.switchcase();
			System.out.println("+----------------------------------------------------------------------------------------------+"); 
		}
		else {
			System.out.println("Somthing went wrong");
			System.out.println("Chack Your userName or Password");
			System.out.println("+----------------------------------------------------------------------------------------------+"); 
		}
	}
}
