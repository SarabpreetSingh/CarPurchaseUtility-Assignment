package com.carpurchaseutility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AdminUtility {
	
	//reader for getting Admin's Input 
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	//customerstore for Storing List Of Customers
	ArrayList<Customer> customerstore=new ArrayList<Customer>();
	//search for Admin searches for particular ID
	String search;
	public final static String NAME_REGEX="^[a-zA-Z\\s]+$";
	public final static String ID_REGEX="^\\d*$";
	
	//Add the Data of Customer to customerstore
	public void addCustomerData() throws IOException {
		String id;
		String name;
		
		System.out.println("Enter Customer ID:");
		id=reader.readLine();

		//Validate id 
		if(id.isEmpty()|| !id.matches(ID_REGEX)) {
			System.out.println("ID is not valid!");
			return;
		}
		//Validate Unique ID
		for(Customer c: customerstore) {
			if(c.getCID()==Integer.parseInt(id)) {														
				System.out.println("Please enter Unique ID");
				return;
			}
		}
		//Validate name
		System.out.println("Enter Customer Name:");
		name=reader.readLine();
		if(name.isEmpty()|| !name.matches(NAME_REGEX)) {
			System.out.println("Name is not valid!");
			return;
		}
		customerstore.add(new Customer(Integer.parseInt(id),name));
		System.out.println("Customer Added Successfully!");
	}
	
	//Add a Car to Customer's Car List
	public void addCar() throws IOException {
		System.out.println("Please Enter ID of the Customer:");

		int carID;
		String model;
		double price;
		String search=reader.readLine();
		for(Customer cu: customerstore) {
			//Validate If User's ID exists in customerstore
			if(Integer.toString(cu.getCID()).contains(search)) {
				
				System.out.println("Customer Found!\nCustomer ID:"+cu.getCID()+"\nCustomer Name:"+cu.getCName()+"\n");
				System.out.println("Please Enter Car Details:\nCar ID: ");
				carID=Integer.parseInt(reader.readLine());
				System.out.println("Model:");
				model=reader.readLine();
				System.out.println("Price:");
				price=Double.parseDouble(reader.readLine());
				
				//Add a car
				cu.addCarToUser(carID,model,price);
				break;
			}else if(customerstore.size()==0){
				System.out.println("Customer Not Found!");
			}
		}
		
	}
	//List a customer based on their ID
	public void listCustomer() throws IOException {
		System.out.println("Enter ID of the Customer for Search:");
		//check for checking Customer exists or Not
		int check=0;
		String search=reader.readLine();
		for(Customer cu: customerstore) {
			if(Integer.toString(cu.getCID()).contains(search)) {
				System.out.println("Customer Exists:\n"+cu.getCID()+"-"+cu.getCName());
				break;
			}else if(customerstore.size()==check){
				System.out.println("Customer Not Found!");
			}
			check++;
		}
	}
	
	//List all Customers in Sorted Order By Name along with their Cars
	public void listAllCustomers() {
		//Sort Customers Based on their Name
		Collections.sort(customerstore, new CompareByName());
		//Show the Sorted List of Customer Along With their Cars
		for(Customer c: customerstore) {
			c.showInfo();
		}
	}
	
	public void prizeGenerator() throws IOException {
		System.out.println(customerstore);
		System.out.println("Here are the rules:\nPick 3 ids from below:");
		System.out.println("======");
		//Access the ids from customerstore List
		for(Customer c:customerstore) {
			System.out.println(c.getCID());
		}
		System.out.println("======");
		
		System.out.println("Enter 3 ids:");
		
		//Storing the entered id to array list:
		ArrayList<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<3;i++) {
			ids.add(Integer.parseInt(reader.readLine()));
		}
		System.out.println("Choosed IDs:"+ids);
		//ln for storing Random Values in a List
		List<Integer> ln=new ArrayList<Integer>();
		
		//Validate if the customer ids < 6
		if(customerstore.size()<6) {
			System.out.println("Must have atleast 6 IDs of Customer!");
			return;
		}else {
			Random rn=new Random();
			for(int i=0;i<6;i++) {
				int no=rn.nextInt(6);
				ln.add(customerstore.get(no).getCID());
			}
		}
		System.out.println("Random IDs:"+ln);
		ln.retainAll(ids);
		
		//Store the match ids in set for removing duplicates
		Set<Integer> set = new HashSet<>(ln);
		ln.addAll(set);
		
		//Validate who won the prize and who didn't
		if(set.isEmpty()) {
			System.out.println("No one won the prize!");
		}
		else {
			for(int i:set) {
			System.out.println("User with ID "+i+" won the prize!");
			}
		}
	}
}
