package org.finance.service;

import java.util.Scanner;

import org.finance.dao.HomeActivity;
import org.finance.model.Group;

public class CreateGroup {

	public Group createNewGroup(int userId) {

		String desc = null;
		Group grp = new Group(0, desc);

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the group name: ");
		grp.setGroupName(scanner.nextLine());

		// passing user id as group id
		grp.setGroupId(userId);
		new HomeActivity().addGroup(grp);

		System.out.println();
		System.out.println("Group created successfully.");
		return grp;
	}

	public int addFriendToGroup(Group group, int usrId) {
		int friendId = 0;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the friend's id: ");
		friendId = Integer.parseInt(scanner.nextLine());

		System.out.println();
		if (usrId == friendId)
			System.out.println("Can't add urself as friend.");
		else {
			new HomeActivity().addFrindToGroup(group, usrId, friendId);
			System.out.println("Friend added successfully to group: " + group.getGroupName());
		}
		return friendId;
	}

}
