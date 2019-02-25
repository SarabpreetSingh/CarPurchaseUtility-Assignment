package util;

import java.util.List;

import model.Customer;

public class Validator {
	
	//RegEx for Validation
	public final static String NAME_REGEX="^[a-zA-Z\\s]+$";
	public final static String ID_REGEX="^\\d*$";
	
	/*
	 * @return True if String has valid number
	 * @return False if String has not valid numbers
	 */
	public final static boolean isNumber(String id) {
		if(id.isEmpty()|| !id.matches(ID_REGEX)) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * @return True if String has valid Name
	 * @return False if String has not valid Name
	 */
	public final static boolean isName(String name) {
		if(name.isEmpty()||!name.matches(NAME_REGEX)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*
	 * @return True if String has unique Id
	 * @return False if String has not unique Id
	 */
	public final static boolean isUniqueId(List<Customer> customerstore,String id) {
		for(Customer c: customerstore) {
			if(c.getCustomerID()==Integer.parseInt(id)) {														
				return false;
			}
		}
		return true;
		
	}
}
