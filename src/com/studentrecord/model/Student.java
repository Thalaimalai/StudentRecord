/**
 * 
 */
package com.studentrecord.model;

import java.sql.Date;

/**
 * @author ThalaimalaiPandiyanT
 *
 */
public class Student {
	private String studentRollNumber;
	private String studentName;
	private String departmentName;
	private String email;
	private String gender;
	private Date dateOfBirth;
	private String address;
	
	public Student() {
		super();
	}

	public Student(String rollNumber, String name, String departmentName, String email, String gender, Date dateOfBirth, String address) {
		this.studentRollNumber = rollNumber;
		this.studentName = name;
		this.departmentName = departmentName;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	
	public String getRollNumber() {
		return studentRollNumber;
	}
	
	public void setRollNumber(String rollNumber) {
		this.studentRollNumber = rollNumber;
	}
	
	public String getName() {
		return studentName;
	}
	
	public void setName(String name) {
		this.studentName = name;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
