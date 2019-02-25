package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import comparator.CompareByName;
import model.Customer;

public class AdminUtility {
	
	//reader for getting Admin's Input 
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	//customerstore for Storing List Of Customers
	ArrayList<Customer> customerstore=new ArrayList<Customer>();
	//search for Admin searches for particular ID
	String search;
	
	//Add the Data of Customer to customerstore
	public void addCustomerData() throws IOException {
		String id;
		String name;
		
		System.out.println("Enter Customer ID:");
		id=reader.readLine();

		//Validate Customer ID
		/*
		 * @param id as Customer ID  
		 */
		if(!Validator.isNumber(id)) {
			System.out.println("ID is not valid!");
			return;
		}
		
		//Validate Unique ID
		/*
		 * @param customerstore as Customer List
		 * @param id as Admin's Entered ID
		 */
		if(!Validator.isUniqueId(customerstore, id)) {
			System.out.println("Please enter Unique ID");
			return;
		}
		
		System.out.println("Enter Customer Name:");
		name=reader.readLine();
		
		//Validate Customer Name
		/*
		 * @param name as Customer Name
		 */
		if(!Validator.isName(name)) {
			System.out.println("Name is not valid!");
			return;
		}
		
		//Add Customer to Customer's List
		customerstore.add(new Customer(Integer.parseInt(id),name));
		System.out.println("Customer Added Successfully!");
	}
	
	//Add a Car to Customer's Car List
	public void addCar() throws IOException {
		System.out.println("Please Enter ID of the Customer:");

		String carID;
		String model;
		String price;
		
		String search=reader.readLine();
		
		for(Customer cu: customerstore) {
			//Validate If User's ID exists in customerstore
			if(Integer.toString(cu.getCustomerID()).contains(search)) {
				
				System.out.println("Customer Found!\nCustomer ID:"+cu.getCustomerID()+"\nCustomer Name:"+cu.getCustomerName()+"\n");
				System.out.println("Please Enter Car Details:\nCar ID: ");
				carID=reader.readLine();
				
				//Validate Car ID
				/*
				 * @param carID as Car ID
				 */
				if(!Validator.isNumber(carID)) {
					System.out.println("ID is not valid!");
					return;
				}
				
				//Validate Unique ID
				/*
				 * @param customerstore as Customer List
				 * @param carID as Admin's Entered Car ID
				 */
				if(!Validator.isUniqueId(customerstore,carID)) {
					System.out.println("Please enter Unique Car ID");
					return;
				}
				
				System.out.println("Model:");
				model=reader.readLine();
				
				System.out.println("Price:");
				price=reader.readLine();
				
				//Validate Price
				/*
				 * @param price as Car Price
				 */
				if(!Validator.isNumber(price)) {
					System.out.println("Price is not valid!");
					return;
				}
				
				//Add a car
				cu.addCarToUser(Integer.parseInt(carID),model,Double.parseDouble(price));
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
		String search=reader.readLine();
		for(Customer cu: customerstore) {
			if(Integer.toString(cu.getCustomerID()).contains(search)) {
				System.out.println("Customer Exists:\n"+cu.getCustomerID()+"-"+cu.getCustomerName());
				return;
			}
		}
		System.out.println("Customer Not Found!");
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
	
	//Random Prize Generator
	public void prizeGenerator() throws IOException {
		/*
		 * @param customerstore as Customer List
		 */
		PrizeGenerator.prizeGenerator(customerstore);
	}
	
}
