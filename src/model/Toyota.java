package model;

public class Toyota extends Car{

	/*
	 * @param carID for Car ID
	 * @param model for Car Model
	 * @param double for Car's Price
	 */
	public Toyota(final int carID,final String model,final double price) {
		super(carID,model,price);
	}

	//Calculate Resale Value  
	@Override
	public double calculateValue(double price) {
		return price*0.6;
	}

	//Show Car Details of a Customer
	@Override
	public void showCarDetails() {
		System.out.println("Car Company: Toyota\n"
				         + "Car Model:"+getModel()+"\n"
				         + "Car Actual Price:"+getPrice()+"\n"
				         + "Car Resale Value:"+calculateValue(getPrice()));
	}


}
