package com.carpurchaseutility;

import java.util.ArrayList;

public class Customer{
	
	//cID for Cutomer ID
	private int cID;
	//cName for Customer Name
	private String cName;
	//cars for Storing CarInfo of a Customer
	private ArrayList<Car> cars =new ArrayList<Car>();
	
	public Customer() {}
	
	/*
	 * @param cid for Customer ID
	 * @param name for Customer Name
	 */
	public Customer(int cid,String name) {
		cID=cid;
		cName=name;
	}
	
	//Get Customer ID
	public int getCID() {
		return cID;
	}
	//Get Customer Name
	public String getCName() {
		return cName;
	}
	//Show the List of Purchased Cars
	public void getPurchasedCarsList() {
		System.out.println("Purchased Cars:");
	}
	//Show Info of particular customer
	public void showInfo() {
		System.out.println("===============");
		System.out.println("ID:"+this.cID+"\nName:"+this.getCName()+"\n----------");
		if (cars.size()==0) {
			System.out.println("Cars: No Cars Owned");
		}else {
			for(Car car:cars) {
				car.showCarDetails();
				System.out.println("\n----------");
			}
		}
		System.out.println("===============");
	}
	//Add a Car to Customer's Car List
	public void addCarToUser(int cid,String model,double price) {
		final Car car;
		//Check the Model of Car 
		if(model.contains("Toyota")) {
			car=new Toyota(cid,model,price);
			cars.add(car);
			System.out.println("Car Successfully Added!");
		}else if(model.contains("Hyundai")) {
			car=new Hyundai(cid,model,price);
			cars.add(car);
			System.out.println("Car Successfully Added!");
		}else if(model.contains("Maruti")) {
			car=new Maruti(cid,model,price);
			cars.add(car);
			System.out.println("Car Successfully Added!");
		}else {
			System.out.println("Model Not Available!");
		}
	}
	
	
}
