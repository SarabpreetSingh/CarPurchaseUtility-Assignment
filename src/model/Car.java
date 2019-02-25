package model;

public abstract class Car extends Customer {
	
	//mID for Car ID
	private int mID;
	//mModel for Car Model
	private String mModel;
	//mPrice for Car Price
	private double mPrice;
	
	/*
	 * @param mID for Car ID
	 * @param mModel for Car Model
	 * @param mPrice for Car Price
	 */
	public Car(int mID,String mModel,double mPrice) {
		this.mID=mID;
		this.mModel=mModel;
		this.mPrice=mPrice;
	}
	
	//Get the Car ID
	/*
	 * @return Car ID
	 */
	public int getCarID() {
		return mID;
	}
	
	//Get Model of Car
	/*
	 * @return Model ID
	 */
	public String getModel() {
		return mModel;
	}
	
	//Get Price of Car
	/*
	 * @return Car Price
	 */
	public double getPrice() {
		return mPrice;
	}
	
	//Calculate resale Values for different Cars
	/*
	 * @param price as Car Price
	 */
	public abstract double calculateValue(double price);
	
	//Show details of the car
	public abstract void showCarDetails();
}
