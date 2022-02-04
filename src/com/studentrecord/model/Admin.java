/**
 * 
 */
package com.studentrecord.model;

/**
 * @author ThalaimalaiPandiyanT
 *
 */
public class Admin {
	 private String adminName;
	    private String adminEmail;
	    private String password;
	    
	    public Admin(String adminName, String adminEmail, String password) {
	    	this.adminName = adminName;
	    	this.adminEmail = adminEmail;
	    	this.password = password;
	    }

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getAdminEmail() {
			return adminEmail;
		}

		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}   
}
