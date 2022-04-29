package com.Microproject;
import java.util.Scanner;
public class SwitchClass {
	public Scanner sc = new Scanner(System.in);
	int choice ;
	public void switchcase() {
		do {
		System.out.println("1.ADD EMPLOYEE");
		System.out.println("2.DELETE EMPLOYEE");
		System.out.println("3.UPDATE INFO OF EMPLOYEE");
		System.out.println("4.SEARCH EMPLOYEE AND PAY SALARY");
		System.out.println("5.DISPLAY EMPLOYEE TABLE");
		System.out.println("6.DISPLAY SALARY TABLE");
		System.out.println("0.LOG OFF ADMIN");
		System.out.println("Enter your choiec : ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			InsertEmployee emp = new InsertEmployee();
			emp.insertEmployee();
			break;
		case 2: 
			DeleteEmployee delEmp = new DeleteEmployee();
			delEmp.deleteEmployee();
			break;
		case 3:
			UpdateEmployee updEmp = new UpdateEmployee();
			updEmp.update();
			break;
		case 4:
			SearchEmployee secEmp = new SearchEmployee();
			secEmp.searchEmployee();
			break;
		case 5:
			Display disEmp = new Display();
			disEmp.displayData();
			break;
		case 6:
			SalaryTable salTeb = new SalaryTable();
			salTeb.showTable();
			break;
		case 0:	
			System.out.println("LOGED OUT SUCCESSFULLY");
			System.out.println("THANKS FOR USING SYSTEM");
			return;
		default:
			System.out.println("Enter correct option !!!");
		}
		}while(choice != 0);
		
	}
		

}
