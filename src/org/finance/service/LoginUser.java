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
			displayHomePage(usr.getId());
		} else
			System.out.println("User does not exist.");
	}

	public void welcomeHome() {
		System.out.println("---- ---- ---- ---- ----");
		System.out.println("Press 1: Add new friend");
		System.out.println("Press 2: Create new group");
		System.out.println("Press 3: Add a bill");
		System.out.println("Press 4: Generate report");
		
		System.out.println("Press 9: Log-off");
		System.out.println();
		System.out.print("Please choose an option: ");
	}
	
	public void displayHomePage(int currId) {
		int option = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		while (true) {
			new LoginUser().welcomeHome();
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (Exception ex) {
				// do nothing
			}

			switch (option) {
			case 1:
				// add new friend
				new AddFriend().addNewFriend(currId);
				break;
			case 2:
				// create new group
				new CreateGroup().createNewGroup(currId);
				// add friends in created group
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 9:
				System.out.println("User logged off.");
				break;
			default:
				System.out.println("Select given options only.");
				break;
			}
			if (option == 9)
				break;
		}
	}
}
