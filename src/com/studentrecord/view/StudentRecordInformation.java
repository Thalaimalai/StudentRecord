package com.studentrecord.view;

import java.sql.Date;

import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.main.StudentRecordMain;

public class StudentRecordInformation {
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();

	public static String getAdminName() {
		System.out.println("Enter Name:");
		return STUDENTRECORD_CONTROLLER.adminName(StudentRecordMain.SCANNER.next());
	}
	
	public static String getEmail() {
		System.out.println("Enter Email:");
		return STUDENTRECORD_CONTROLLER.email(StudentRecordMain.SCANNER.next());
	}
	
	public static String getPassword() {
		System.out.println("Enter Admin Password:");
		return STUDENTRECORD_CONTROLLER.adminPassword(StudentRecordMain.SCANNER.next());
	}

	public static String getStudentRollNumber() {
		System.out.println("Enter Student Roll Number");
		return STUDENTRECORD_CONTROLLER.studentRollNumber(StudentRecordMain.SCANNER.next());
	}
	
    public static String getStudentName() {
		System.out.println("Enter Student Name:");
		return STUDENTRECORD_CONTROLLER.studentName(StudentRecordMain.SCANNER.next());
	}

	public static String getDepartmentName() {
		System.out.println("Enter Department Name");
		return STUDENTRECORD_CONTROLLER.departmentName(StudentRecordMain.SCANNER.next());
	}

	public static String getGender() {
		System.out.println("Enter Student Gender");
		return STUDENTRECORD_CONTROLLER.getGender(StudentRecordMain.SCANNER.next());
	}

	public static Date getDateOfBirth() {
		System.out.println("Enter Student Date-of-Birth");
		return STUDENTRECORD_CONTROLLER.getDateOfBirth(StudentRecordMain.SCANNER.next());
	}

	public static String getAddress() {
		System.out.println("Enter Student Address");
		return STUDENTRECORD_CONTROLLER.getAddress(StudentRecordMain.SCANNER.next());
	}
}
