package com.studentrecord.main;

import java.sql.Date;
import java.util.Scanner;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.model.Admin;
import com.studentrecord.model.Student;
import com.studentrecord.view.StudentRecordInformation;

public class StudentRecordMain {
   	public static final Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTCONTROLLER = new StudentRecordController();
	private static int choice;

	public static void main(String[] args) {
		System.out.println("1.Admin Login\n2.Admin Signup\n3.StudentLogin");
		choice = SCANNER.nextInt();

		switch (choice) {
		case 1:
			StudentRecordMain.adminLogin();
			break;
		case 2:
			StudentRecordMain.adminSignup();
			break;
		case 3:
			StudentRecordMain.studentLogin();
			break;
		default:
			SCANNER.close();
			System.exit(0);
		}
	}

	private static void adminSignup() {
		String adminName = StudentRecordInformation.getAdminName();
		String adminEmail = StudentRecordInformation.getEmail();
		String password = StudentRecordInformation.getPassword();
		
		Admin admin = new Admin(adminName, adminEmail, password);

		STUDENTCONTROLLER.adminSignup(admin);
	}

	private static void adminLogin() {
		String adminEmail = StudentRecordInformation.getEmail();
		String password = StudentRecordInformation.getPassword();
		
		STUDENTCONTROLLER.adminLogin(adminEmail, password);
	}

	private static void studentLogin() {
        String rollNumber = StudentRecordInformation.getStudentRollNumber();
        String studentName = StudentRecordInformation.getStudentName();
        
        STUDENTCONTROLLER.studentLogin(rollNumber, studentName);
	}
	
	public static void getAdminWorks() {
		System.out.println("1.Insert 2.View 3.Delete 4.Update");
	    choice = SCANNER.nextInt();
	    
	    if(choice == 1) {
	    	getStudentDetails();
	    } else if(choice == 2) {
	    	viewStudentDetails();
	    } else if(choice == 3) {
	    	deleteStudentDetails();
	    } else if (choice == 4) {
	    	updateStudentDetails();
	    } else {
	    	System.out.println("Not a Valid Choice");
	    }
	}

	private static void getStudentDetails() {
		String rollNumber = StudentRecordInformation.getStudentRollNumber();
        String studentName = StudentRecordInformation.getStudentName();
        String departmentName = StudentRecordInformation.getDepartmentName();
        String email = StudentRecordInformation.getEmail();
        String gender = StudentRecordInformation.getGender();
        Date dateOfBirth = StudentRecordInformation.getDateOfBirth();
        String address = StudentRecordInformation.getAddress();
        
        Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address);
        
        STUDENTCONTROLLER.insertStudentDetails(student);
	}
	
	private static void viewStudentDetails() {
		String rollNumber = StudentRecordInformation.getStudentRollNumber();
		
		STUDENTCONTROLLER.viewStudentDetails(rollNumber);
	}
	
    private static void deleteStudentDetails() {
        String rollNumber = StudentRecordInformation.getStudentRollNumber();
		
		STUDENTCONTROLLER.deleteStudentDetails(rollNumber);	
	}
    
    private static void updateStudentDetails() {
		
	}
}
