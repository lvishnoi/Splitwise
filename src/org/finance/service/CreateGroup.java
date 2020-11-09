package org.finance.service;

import java.util.Scanner;

import org.finance.dao.HomeActivity;
import org.finance.model.Group;

public class CreateGroup {
	
	public void createNewGroup(int userId) {
		
		String desc = null;	
		Group grp = new Group(0, desc);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the group name: ");
		grp.setGroupName(scanner.nextLine());
		
		//passing user id as group id
		grp.setGroupId(userId);
		new HomeActivity().addGroup(grp);
		
		System.out.println();
		System.out.println("Group created successfully.");
		
	}

}
