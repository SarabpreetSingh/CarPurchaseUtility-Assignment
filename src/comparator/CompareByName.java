package comparator;

import java.util.Comparator;

import model.Customer;

public class CompareByName implements Comparator<Customer>{

	/*Comparing Customer's Object for Sorting based on their names
	 *@return Two Names in Sorted Order 
	 */
	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getCustomerName().compareTo(o2.getCustomerName());
	}

}
