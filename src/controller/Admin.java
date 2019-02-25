package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.AdminUtility;
import util.Validator;
public class Admin extends AdminUtility{
	
	public static void main(String[] args) throws IOException {
		//reader for getting Admin's Input 
		final BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//util for accessing AdminUtility class methods
		final AdminUtility util = new AdminUtility();
		//choice for Admin choice for Operations
		String choice;
		//option for check if admin want to choose again
		String option;
		do {
			System.out.println("Welcome to Car Purchase!\n"
					+ "1.Add a Customer\n"
					+ "2.Add a Car to Customer\n"
					+ "3.List a Customer\n"
					+ "4.List all Customers (Sorted by Name)\n"
					+ "5.Pick a Prize Winner\n"
					+ "Enter your Choice:");
			choice=reader.readLine();
			
			//Check if string is character
			if(!Validator.isNumber(choice)||choice.isEmpty()) {
				System.out.println("You should enter a number!Quitting...");
				return;
			}
			
			switch(Integer.parseInt(choice)) {
			
			//Add a customer
			case 1:
				util.addCustomerData();
				break;
				
			//Add a Car to Customer
			case 2:
				util.addCar();
				break;
				
			//List a Customer
			case 3:
				util.listCustomer();
				break;
				
			//List all Customers (Sorted by Name) 
			case 4:
				util.listAllCustomers();
				break;
			//Random Prize Generator
			case 5:
				util.prizeGenerator();
				break;
			default:
				System.out.println("Invalid Choice");	
			}
			
			System.out.println("\nPress 'y' to Continue\nPress 'n' to Exit\n");
			option=reader.readLine();
			System.out.println("-----------------------------");
		}while(option.equals("y") || option.equals("Y"));
		
		System.out.println("Thank You!");
	}
}