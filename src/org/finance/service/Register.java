package org.finance.service;

import java.util.Scanner;

import org.finance.dao.Activity;
import org.finance.model.User;

public class Register {

	public int registerUser() {
		String name = null;
		String passcode = null;
		
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		User usr = new User(name, passcode);

		System.out.print("Enter the name: ");
		usr.setName(sc1.nextLine());

		System.out.print("Enter the passcode: ");
		usr.setPasscode(sc1.nextLine());
				
		return new Activity().createUser(usr);
	}
}
