package org.finance.service;

import java.util.HashMap;
import java.util.Map;

import org.finance.dao.Activity;
import org.finance.dao.BillActivity;

public class AccountSummary {
	
	public void displayStatement(int user) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		String out = "";
		
		hm = new BillActivity().getFullStatement(user);
		System.out.println();
		for (@SuppressWarnings("rawtypes") Map.Entry mapElement : hm.entrySet()) {
			int friendId = (int) mapElement.getKey();
			out = new Activity().getUser(friendId) + "   :   " + mapElement.getValue();
			System.out.println(out);
        } 
		System.out.println();
	}

}
