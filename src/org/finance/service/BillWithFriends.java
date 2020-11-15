package org.finance.service;

import java.util.HashSet;
import java.util.Scanner;

import org.finance.dao.BillActivity;
import org.finance.dao.HomeActivity;

public class BillWithFriends {

	public void shareBillWithFriends(int userId) {
		
		String inputFriends;
		HashSet<Integer> friends = new HashSet<Integer>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		friends = new HomeActivity().getAllFriends(userId);
		if (friends.isEmpty()) {
			System.out.println("Add some friends to continue..");
		} else {
			System.out.println();
			System.out.print("All friends: ");
			for (int i : friends)
				System.out.print(i + ", ");
			System.out.println();
			System.out.print("Input friend IDs followed by space: ");
			inputFriends = sc.nextLine();
			System.out.print("Enter the amount: ");
			String[] list = inputFriends.split(" ");
			int amount = Integer.parseInt(sc.nextLine());
			if (list.length > 1)
				new BillActivity().updateBillInDatabase(list, amount, userId, 0);
		}
	}
}
