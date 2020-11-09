package org.finance.service;

import java.util.Scanner;

import org.finance.dao.Activity;
import org.finance.model.User;

public class LoginUser {

	public void logUser() {
		int id = 0;
		String name = null;
		String passcode = null;

		User usr = new User(id, null, passcode);
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("Enter the id: ");
		usr.setId(Integer.parseInt(sc1.nextLine()));

		System.out.print("Enter the passcode: ");
		usr.setPasscode(sc1.nextLine());

		name = new Activity().getUserName(usr);
		System.out.println();
		
		if (name != null && name.length() > 0) {
			System.out.println("Welcome: " + name.toUpperCase());
			// redirect to another activity
			
		}
		else
			System.out.println("User does not exist.");
	}
}
