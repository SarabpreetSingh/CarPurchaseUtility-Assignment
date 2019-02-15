package com.carpurchaseutility;

import java.util.Comparator;

public class CompareByName implements Comparator<Customer>{

	//Comparing Customer's Object for Sorting based on their names
	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.getCName().compareTo(o2.getCName());
	}

}
