package com.studentrecord.main;

import java.util.InputMismatchException;
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

	/**
	 * Illustrates the login and signup for users.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1.Admin Login\n2.Admin Signup\n3.StudentLogin\nEnter Your Choice ");

		try {
			int choice = Integer.parseInt(StudentRecordInformation.SCANNER.nextLine());

			switch (choice) {
			case 1:
				StudentRecordInformation.adminLogin();
				break;
			case 2:
				StudentRecordInformation.adminSignup();
				break;
			case 3:
				StudentRecordInformation.studentLogin();
				break;
			default:
				StudentRecordInformation.SCANNER.close();
				System.exit(0);
			}
		} catch (InputMismatchException exception) {
			System.out.println("Enter Valid Choice");
		}
	}
}
