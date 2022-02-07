package com.studentrecord.main;

import java.util.InputMismatchException;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.view.StudentRecordInformation;

/**
 * <h1>StudentRecordManagement</h1> The Student Record Management in which
 * student can login to view their record which was maintained by the Management
 * Admin that they could view, delete, insert and update to maintain the student
 * records for the Management.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordMain {
	private static final StudentRecordController STUDENT_CONTROLLER = new StudentRecordController();

	/**
	 * The main method illustrates the login for admin and user.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1.Admin Login\n2.Admin Signup\n3.StudentLogin\nEnter Your Choice ");

		try {
			int choice = Integer.parseInt(StudentRecordInformation.SCANNER.nextLine());

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
				StudentRecordInformation.SCANNER.close();
				System.exit(0);
			}
		} catch (InputMismatchException exception) {
			System.out.println("Enter Valid Choice");
		}
	}

	/**
	 * Get the credential of admin to signUp for the first time.
	 */
	private static void adminSignup() {
		final String adminName = StudentRecordInformation.getAdminName();
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();

		STUDENT_CONTROLLER.adminSignup(adminName, adminEmail, password);
	}

	/**
	 * Admin login to maintain the student record.
	 */
	private static void adminLogin() {
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();

		STUDENT_CONTROLLER.adminLogin(adminEmail, password);
	}

	/**
	 * Student login with their credential to view thier respective record.
	 */
	private static void studentLogin() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getStudentName();

		STUDENT_CONTROLLER.studentLogin(rollNumber, studentName);
	}
}