package com.studentrecord.controller;

import java.sql.Date;
import com.studentrecord.main.StudentRecordMain;
import com.studentrecord.model.Student;
import com.studentrecord.service.*;

public class StudentRecordController {
	private static final StudentInformationService STUDENT_SERVICES = new StudentInformationService();
	
	public String adminName(String name) {
		return STUDENT_SERVICES.validateName(name);
	}

	public String email(String email) {
		return STUDENT_SERVICES.validateEmail(email);
	}

	public String adminPassword(String password) {
		return STUDENT_SERVICES.validateAdminPassword(password);
	}
	
	public String studentRollNumber(String rollNumber) {
		return STUDENT_SERVICES.validateStudentRollNumber(rollNumber);
	}
	
	public String departmentName(String departmentName) {
		return STUDENT_SERVICES.validateDepatementName(departmentName);		
	}

	public String getGender(String gender) {
		return STUDENT_SERVICES.validateGender(gender);
	}

	public Date getDateOfBirth(String dateOfBirth) {
		return STUDENT_SERVICES.validateDOB(dateOfBirth);
	}

	public String getAddress(String address) {
		return STUDENT_SERVICES.validateAddress(address);
	}
	
	public void adminSignup(final String adminName, final String adminEmail, final String password) {
		STUDENT_SERVICES.insertAdminSignup(adminName, adminEmail, password);
	}

	public void adminLogin(final String adminEmail, final String password) {
		STUDENT_SERVICES.getAdminLogin(adminEmail, password);	
	}

	public void studentLogin(final String rollNumber, final String studentName) {
		STUDENT_SERVICES.studentLogin(rollNumber, studentName);
	}
	
	public static void getAdminWorks() {
		StudentRecordMain.getAdminWorks();
	}

	public void insertStudentDetails(Student student) {
		STUDENT_SERVICES.insertStudentDetails(student);
	}

	public String studentName(String studentName) {
		return STUDENT_SERVICES.validateStudentName(studentName);
	
	}

	public void viewStudentDetails(String rollNumber) {
		STUDENT_SERVICES.viewStudentDetails(rollNumber);
	}
}
