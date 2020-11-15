package org.finance.controller;

import java.util.Scanner;

import org.finance.service.Register;

public class Home {

	public static void main(String[] args) {

		int input = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		while (true) {
			new Home().welcomeMsg();
			try {
				input = Integer.parseInt(scanner.nextLine());
			} catch (Exception ex) {
				// do nothing
			}

			switch (input) {
			case 1:
				// Login event
				new LoginUser().logUser();
				break;
			case 2:
				// Register user
				System.out.println();
				System.out.println("User created with id: " + new Register().registerUser());
				break;
			case 9:
				System.out.println("Application terminated.");
				break;
			default:
				System.out.println("Select given options only.");
				break;
			}

			if (input == 9)
				break;
		}
	}

	public void welcomeMsg() {
		System.out.println("****** ******* ******* *******");
		System.out.println("Press 1: Login");
		System.out.println("Press 2: Register");
		System.out.println("Press 9: Exit");
		System.out.println();
		System.out.print("Please enter an option: ");
	}

}
