package org.finance.service;

import java.util.Scanner;

import org.finance.dao.HomeActivity;

public class AddFriend {
	
	public void addNewFriend(int currId) {
		int id = 0;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the friend's id: ");
		id = Integer.parseInt(scanner.nextLine());
		
		System.out.println();
		if (currId == id)
			System.out.println("Can't add urself as friend.");
		else {
			new HomeActivity().addFriend(currId, id);
			System.out.println("Friend added successfully.");
		}
	}

}
