package com.Microproject;

import java.util.Scanner;

public class MainClass {
	private static String admin = "system";
	private static String pass = "ritp1227";
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
		
		if(admin.equals(userName) && pass.equals(password)) {
			System.out.println("Your Loged in Successfully...");
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
