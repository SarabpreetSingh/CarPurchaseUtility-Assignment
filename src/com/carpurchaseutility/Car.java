package com.carpurchaseutility;

public abstract class Car extends Customer {
	
	//mID for Car ID
	private int mID;
	//Model for Car Model
	private String Model;
	//mPrice for Car Price
	private double mPrice;
	
	/*
	 * @param id for Car ID
	 * @param model for Car Model
	 * @param double for Car Price
	 */
	public Car(int id,String model,double price) {
		mID=id;
		Model=model;
		mPrice=price;
	}
	
	//Get the Car ID
	public int getCarID() {
		return mID;
	}
	//Get Model of Car
	public String getModel() {
		return Model;
	}
	//Get Price of Car
	public double getPrice() {
		return mPrice;
	}
	//Calculate resale Values for different Cars
	public abstract double calculateValue(double price);
	//Show details of the car
	public abstract void showCarDetails();
}
