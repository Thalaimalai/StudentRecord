package com.studentrecord.main;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.model.Student;
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
		final Scanner scanner = new Scanner(System.in);
		System.out.println("1.Admin Login\n2.Admin Signup\n3.StudentLogin");

		try {
			int choice = scanner.nextInt();

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
				scanner.close();
				System.exit(0);
			}
		} catch (InputMismatchException exception) {
			System.out.println("Enter Valid Choice");
		}
	}

	/**
	 * Get the credential of admin to signUp for first time.
	 */
	private static void adminSignup() {
		final String adminName = StudentRecordInformation.getAdminName();
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();

		STUDENT_CONTROLLER.adminSignup(adminName, adminEmail, password);
	}

	/**
	 * Admins login to maintain the student record.
	 */
	private static void adminLogin() {
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();

		STUDENT_CONTROLLER.adminLogin(adminEmail, password);
	}

	/**
	 * Students login with their credential to view thier respective record.
	 */
	private static void studentLogin() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getStudentName();

		STUDENT_CONTROLLER.studentLogin(rollNumber, studentName);
	}

	/**
	 * Get the information of students to insert.
	 */
	public static void insertStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getStudentName();
		final String departmentName = StudentRecordInformation.getDepartmentName();
		final String email = StudentRecordInformation.getEmail();
		final String gender = StudentRecordInformation.getGender();
		final Date dateOfBirth = StudentRecordInformation.getDateOfBirth();
		final String address = StudentRecordInformation.getAddress();

		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth,
				address);

		STUDENT_CONTROLLER.insertStudentDetails(student);
	}

	/**
	 * View the respective student records.
	 */
	public static void viewStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();

		STUDENT_CONTROLLER.viewStudentDetails(rollNumber);
	}

	/**
	 * Delete the respective records of student.
	 */
	public static void deleteStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();

		STUDENT_CONTROLLER.deleteStudentDetails(rollNumber);
	}

	/**
	 * Update the student records.
	 */
	public static void updateStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getStudentName();
		final String departmentName = StudentRecordInformation.getDepartmentName();
		final String email = StudentRecordInformation.getEmail();
		final String gender = StudentRecordInformation.getGender();
		final Date dateOfBirth = StudentRecordInformation.getDateOfBirth();
		final String address = StudentRecordInformation.getAddress();

		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth,
				address);

		STUDENT_CONTROLLER.updateStudentDetails(student);
	}
}
