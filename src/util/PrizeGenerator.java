package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.Customer;

public class PrizeGenerator {
	
	//reader for getting Admin's Input 
	static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
	//Choose Prize Winner From The Customer List
	/*
	 * @param customerstore as Customer List
	 * @Show Shows the ID of Winner Customer
	 */
		
	public static void prizeGenerator(List<Customer> customerstore) throws IOException {
		//Stores the Admin's Entered IDs
		ArrayList<Integer> adminChoosedIds=new ArrayList<Integer>();
		//Stores Random IDs from the Customer IDs
		Set<Integer> systemChoosedIds=new HashSet<>();
		
		System.out.println("Here are the rules:\nPick 3 ids from below:");
		System.out.println("======");
		
		//Access the ids from customerstore List
		for(Customer c:customerstore) {
			System.out.println(c.getCustomerID());
		}
		System.out.println("======");
		
		System.out.println("Enter 3 ids:");
		
		//Get 3 Ids from Admin
		for(int i=0;i<3;i++) {
			adminChoosedIds.add(Integer.parseInt(reader.readLine()));
		}
		System.out.println("Choosed IDs:"+adminChoosedIds);
		
		//Validate if the customer ids < 6
		if(customerstore.size()<6) {
			System.out.println("Must have atleast 6 IDs of Customer!");
			return;
		}else {
			Random rn=new Random();
			for(int i=0;i<6;i++) {
				int no=rn.nextInt(6);
				systemChoosedIds.add(customerstore.get(no).getCustomerID());
			}
		}
		//RetainAll will choose matched IDs 
		systemChoosedIds.retainAll(adminChoosedIds);
		
		//Validate who won the prize and who didn't
		if(systemChoosedIds.isEmpty()) {
			System.out.println("No one won the prize!");
		}
		else {
			for(int i:systemChoosedIds) {
			System.out.println("User with ID "+i+" won the prize!");
			}
		}
	}
}
