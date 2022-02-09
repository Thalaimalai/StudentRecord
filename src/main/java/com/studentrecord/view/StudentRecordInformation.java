package com.studentrecord.view;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.exception.CustomException;
import com.studentrecord.exception.CustomException.RecordNotfoundException;
import com.studentrecord.model.Student;

/**
 * Get all information from the users.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordInformation {

	public static final Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();

	/**
	 * Get the name.
	 * 
	 * @return Name
	 */
	public static String getName() {
		System.out.println("Enter Name:");
		final String name = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidName = STUDENTRECORD_CONTROLLER.name(name);

		if (isValidName) {
			return name;
		} else {
			return StudentRecordInformation.getName();
		}
	}

	/**
	 * Get the Email.
	 * 
	 * @return Email
	 */
	public static String getEmail() {
		System.out.println("Enter Email:");
		final String email = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidEmail = STUDENTRECORD_CONTROLLER.email(email);

		if (isValidEmail) {
			return email;
		} else {
			return StudentRecordInformation.getEmail();
		}
	}

	/**
	 * Get the password.
	 * 
	 * @return Password
	 */
	private static String getPassword() {
		System.out.println("Enter Admin Password:");
		final String password = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidPassword = STUDENTRECORD_CONTROLLER.adminPassword(password);

		if (isValidPassword) {
			return password;
		} else {
			return StudentRecordInformation.getPassword();
		}
	}

	/**
	 * Get the student roll number.
	 * 
	 * @return Roll number
	 */
	public static String getStudentRollNumber() {
		System.out.println("Enter Student Roll Number");
		final String rollNumber = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidRollNumber = STUDENTRECORD_CONTROLLER.studentRollNumber(rollNumber);

		if (isValidRollNumber) {
			return rollNumber;
		} else {
			return StudentRecordInformation.getPassword();
		}
	}

	/**
	 * Get student department name.
	 * 
	 * @return Department
	 */
	public static String getDepartmentName() {
		System.out.println("Enter Department Name");
		final String departmentName = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidDepartmentName = STUDENTRECORD_CONTROLLER.departmentName(departmentName);

		if (isValidDepartmentName) {
			return departmentName;
		} else {
			return StudentRecordInformation.getDepartmentName();
		}
	}

	/**
	 * Get the student gender.
	 * 
	 * @return Gender
	 */
	public static String getGender() {
		System.out.println("Enter Student Gender");
		final String gender = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidGender = STUDENTRECORD_CONTROLLER.gender(gender);

		if (isValidGender) {
			return gender;
		} else {
			return StudentRecordInformation.getGender();
		}
	}

	/**
	 * Get student Date-of-birth.
	 * 
	 * @return DOB
	 */
	public static Date getDateOfBirth() {
		System.out.println("Enter Student Date-of-Birth (yyyy-MM-dd)");
		return STUDENTRECORD_CONTROLLER.dateOfBirth(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the address of the student.
	 * 
	 * @return Address
	 */
	public static String getAddress() {
		System.out.println("Enter Student Address");
		final String address = StudentRecordInformation.SCANNER.nextLine();

		final boolean isValidAddress = STUDENTRECORD_CONTROLLER.address(address);

		if (isValidAddress) {
			return address;
		} else {
			return StudentRecordInformation.getAddress();
		}
	}

	/**
	 * Get the credential to signup.
	 */
	public static void adminSignup() {
		final String adminName = StudentRecordInformation.getName();
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();

		try {
			final boolean isInserted = STUDENTRECORD_CONTROLLER.adminSignup(adminName, adminEmail, password);

			if (isInserted) {
				System.out.println("Admin Details Inserted Successfully");
				StudentRecordInformation.adminLogin();
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Get the credential to login.
	 */
	public static void adminLogin() {
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();
		
		try {
			boolean isLogin = STUDENTRECORD_CONTROLLER.adminLogin(adminEmail, password);
		
			if (isLogin) {
				System.out.println("Log in Successfully");
				StudentInformation.showAdminWorks();
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}
	
	/**
	 * Student login to view thier respective record.
	 */
	public static void studentLogin() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getName();

		try {
			boolean isLogin = STUDENTRECORD_CONTROLLER.studentLogin(rollNumber, studentName);
			
			if (isLogin) {
				System.out.println("Login Successfully");
				StudentInformation.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
			}	
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}
}
