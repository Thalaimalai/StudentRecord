package com.studentrecord.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.dao.StudentRecordDAO;
import com.studentrecord.dao.StudentRecordDAOImpl;
import com.studentrecord.model.Admin;
import com.studentrecord.model.Student;
import com.studentrecord.view.StudentRecordInformation;

public class StudentInformationService {
	private static final StudentRecordDAO STUDENTRECORD_DAO = new StudentRecordDAOImpl();
    public String validateName(String name) {
		
		if(!name.matches("^[a-zA-Z\\s]*$")) {
			System.out.println("Please Enter Valid Name");
			StudentRecordInformation.getAdminName();
		} 
		return name;
	}

	public String validateEmail(String email) {
		
		if(!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			System.out.println("Please Enter Valid Email");
			StudentRecordInformation.getEmail();
		}
		return email;
	}
	
	public String validateAdminPassword(String password) {
		
		if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
			System.out.println("Please Enter Valid Password");
			StudentRecordInformation.getPassword();
		}
		return password;
	}
	
    public String validateStudentRollNumber(String rollNumber) {
        
    	if(!(rollNumber.matches("[0-9]{3}"))) {
    	   	System.out.println("Please Enter Valid Roll Number");
			StudentRecordInformation.getStudentRollNumber();
    	} 
		return rollNumber;
	}
    
    public String validateStudentName(String studentName) {
		
		if(!studentName.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$")) {
			System.out.println("Please Enter Valid Name");
			StudentRecordInformation.getStudentName();
		} 
		return studentName;
	}

	public String validateDepatementName(String departmentName) {
		
		if(!departmentName.matches("^[a-zA-Z\\s]*$")) {
			System.out.println("Please Enter Valid Department");
			StudentRecordInformation.getDepartmentName();
		}
		return departmentName;
	}

	public String validateGender(String gender) {
		
		if(!(gender.matches("^M(ale)?$|^F(emale)?$"))) {
			System.out.println("Please Enter Valid Gender");
			StudentRecordInformation.getGender();
		}
		return gender;
	}

	public Date validateDOB(String dateOfBirth) {
		Date sqlDate;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
            java.util.Date date = dateFormat.parse(dateOfBirth);
            sqlDate = new Date(date.getTime()); 
        } catch (Exception exception) {   	
	        System.out.println("Please enter valid date");
	        return StudentRecordInformation.getDateOfBirth();
        }
	    return sqlDate;
	}
	
    public String validateAddress(String address) {
    	
    	if(!address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*")) {
    		System.out.println("Please Enter Valid Address");
    		StudentRecordInformation.getAddress();
    	}
		return address;
	}
    
    public static void getAdminWorks() {
		StudentRecordController.getAdminWorks();
	}

	public void insertAdminSignup(String adminName, String adminEmail, String password) {
		STUDENTRECORD_DAO.insertAdminSignup(adminName, adminEmail, password);
	}

	public void getAdminLogin(String adminEmail, String password) {
		STUDENTRECORD_DAO.getAdminLogin(adminEmail, password);
	}

	public void studentLogin(String rollNumber, String studentName) {
		STUDENTRECORD_DAO.studentLogin(rollNumber, studentName);
	}

	public void insertStudentDetails(Student student) {
		STUDENTRECORD_DAO.insertStudentDetails(student);
	}

	public void viewStudentDetails(String rollNumber) {
		STUDENTRECORD_DAO.viewStudentDetails(rollNumber);
	}	
}
