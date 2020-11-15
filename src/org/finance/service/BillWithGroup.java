package org.finance.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.finance.dao.BillActivity;
import org.finance.dao.GroupActivity;

public class BillWithGroup {

	public void shareBillWithFriends(int userId) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> members = new ArrayList<Integer>();
		int groupId;
		int amount;

		list = new GroupActivity().getPossibleGroups(userId);
		System.out.print("Available Groups: ");
		for (int i : list)
			System.out.print(i + ", ");
		System.out.println();
		System.out.println();

		System.out.print("Enter the Group ID: ");
		groupId = Integer.parseInt(sc.nextLine());
		System.out.print("Enter the amount: ");
		amount = Integer.parseInt(sc.nextLine());

		members = new GroupActivity().getGroupMembers(groupId);
		String[] friends = new String[members.size() - 1];
		int count = 0;
		for (int i = 0; i < members.size(); i++) {
			if (userId == members.get(i))
				continue;
			friends[count++] = members.get(i) + "";
		}
		if (friends.length > 1)
			new BillActivity().updateBillInGroup(friends, amount, userId, groupId);
	}
}
