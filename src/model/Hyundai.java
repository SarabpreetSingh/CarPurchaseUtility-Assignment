package model;

public class Hyundai extends Car{

	/*
	 * @param carID for Car ID
	 * @param model for Car Model
	 * @param double for Car's Price
	 */
	public Hyundai(final int carID,final String model,final double price) {
		//Call Car's Constructor
		super(carID,model,price);
	}

	//Calculate Resale Value  
	@Override
	public double calculateValue(double price) {
		return price*0.8;
	}
	
	//Show Car Details of a Customer
	@Override
	public void showCarDetails() {
		System.out.println("Car Company: Hyundai\n"
						 + "Car Model:"+getModel()+"\n"
						 + "Car Actual Price:"+getPrice()+"\n"
						 + "Car Resale Value:"+calculateValue(getPrice()));
	}

}

