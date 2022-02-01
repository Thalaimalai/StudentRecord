package com.studentrecord.model;

public class Admin {
    private static String adminName;
    private static String adminEmail;
    private static String password;
 
    public Admin() {
    	super();
    }
    
    public Admin(String adminName, String adminEmail, String password) {
    	this.adminName = adminName;
    	this.adminEmail = adminEmail;
    	this.password = password;
    }

	public static String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public static String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
}
