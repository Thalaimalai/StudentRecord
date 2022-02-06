package com.studentrecord.view;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.main.StudentRecordMain;

/**
 * Represents the user view to collect the all information.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordInformation {
	public final static Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();

	/**
	 * Get the admin name.
	 * 
	 * @return Name
	 */
	public static String getAdminName() {
		System.out.println("Enter Name:");
		return STUDENTRECORD_CONTROLLER.adminName(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the user Email.
	 * 
	 * @return Email
	 */
	public static String getEmail() {
		System.out.println("Enter Email:");
		return STUDENTRECORD_CONTROLLER.email(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the admin password.
	 * 
	 * @return Password
	 */
	public static String getPassword() {
		System.out.println("Enter Admin Password:");
		return STUDENTRECORD_CONTROLLER.adminPassword(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the student roll number.
	 * 
	 * @return Roll number
	 */
	public static String getStudentRollNumber() {
		System.out.println("Enter Student Roll Number");
		return STUDENTRECORD_CONTROLLER.studentRollNumber(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the student name.
	 * 
	 * @return name
	 */
	public static String getStudentName() {
		System.out.println("Enter Student Name:");
		return STUDENTRECORD_CONTROLLER.studentName(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get student department name.
	 * 
	 * @return Department
	 */
	public static String getDepartmentName() {
		System.out.println("Enter Department Name");
		return STUDENTRECORD_CONTROLLER.departmentName(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the student gender.
	 * 
	 * @return Gender
	 */
	public static String getGender() {
		System.out.println("Enter Student Gender");
		return STUDENTRECORD_CONTROLLER.getGender(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get student Date-of-birth.
	 * 
	 * @return DOB
	 */
	public static Date getDateOfBirth() {
		System.out.println("Enter Student Date-of-Birth");
		return STUDENTRECORD_CONTROLLER.getDateOfBirth(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Get the student Address.
	 * 
	 * @return Address
	 */
	public static String getAddress() {
		System.out.println("Enter Student Address");
		return STUDENTRECORD_CONTROLLER.getAddress(StudentRecordInformation.SCANNER.nextLine());
	}

	/**
	 * Show the admin duties for modification of the student records.
	 */

	public static void showAdminWorks() {
		
		do {
			System.out.println("1.Insert 2.View 3.Delete 4.Update");

			try {
				int choice = Integer.parseInt(StudentRecordInformation.SCANNER.nextLine());

				if (choice == 1) {
					StudentRecordMain.insertStudentDetails();
				} else if (choice == 2) {
					StudentRecordMain.viewStudentDetails();
				} else if (choice == 3) {
					StudentRecordMain.deleteStudentDetails();
				} else if (choice == 4) {
					StudentRecordMain.updateStudentDetails();
				} else {
					SCANNER.close();
					System.exit(0);
				}
			} catch (InputMismatchException exception) {
				System.out.println("Enter Valid Choice");
			}
		} while (true);
	}
}
