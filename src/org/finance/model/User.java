package org.finance.model;

public class User {
	
	private int id;
	private String name;
	private String passcode;
	
	public User(int id, String name, String passcode) {
		super();
		this.id = id;
		this.name = name;
		this.passcode = passcode;
	}
	
	public User(String name, String passcode) {
		super();
		this.name = name;
		this.passcode = passcode;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

}
