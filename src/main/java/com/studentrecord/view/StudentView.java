package com.studentrecord.view;

import java.sql.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.exception.CustomException;
import com.studentrecord.main.StudentManagement;

/**
 * Get all information from the users.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentView {

	public static final Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	private static final Logger LOGGER = Logger.getLogger(StudentView.class);

	/**
	 * Get choice.
	 * 
	 * @return choice
	 */
	public static String getChoice() {
		LOGGER.info("Enter Choice:");
		final String choice = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(choice)) {
			StudentManagement.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkChoice(choice)) {
			return choice;
		} else {
			LOGGER.warn("Enter Valid Choice:");
			return StudentView.getChoice();
		}
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	static String getName() {
		LOGGER.info("Enter Name:\nPress # To Exit");
		final String name = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(name)) {
			StudentManagement.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkName(name)) {
			return name;
		} else {
			LOGGER.warn("Enter Valid Name:\nPress # To Exit");
			return StudentView.getName();
		}
	}

	/**
	 * Get the Email.
	 * 
	 * @return Email
	 */
	static String getEmail() {
		LOGGER.info("Enter Email:\nPress # To Exit");
		final String email = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(email)) {
			StudentManagement.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkEmail(email)) {
			return email;
		} else {
			LOGGER.warn("Enter Valid Email:\nPress # To Exit");
			return StudentView.getEmail();
		}
	}

	/**
	 * Get the password.
	 * 
	 * @return Password
	 */
	private static String getPassword() {
		LOGGER.info("Enter Admin Password:\nPress # To Exit");
		final String password = StudentView.SCANNER.nextLine();

		if ("#".equals(password)) {
			StudentManagement.selectChoice();
		}

		if (STUDENTRECORD_CONTROLLER.checkAdminPassword(password)) {
			return password;
		} else {
			LOGGER.warn("Enter Valid Password:\nPress # To Exit");
			return StudentView.getPassword();
		}
	}

	/**
	 * Get student roll number.
	 * 
	 * @return Roll number
	 */
	static String getStudentRollNumber() {
		LOGGER.info("Enter Student Rollnumber\nPress # To Exit");
		final String rollNumber = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(rollNumber)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkStudentRollNumber(rollNumber)) {
			return rollNumber;
		} else {
			LOGGER.warn("Enter Valid Rollnumber:\nPress # To Exit");
			return StudentView.getStudentRollNumber();
		}
	}

	/**
	 * Get student department name.
	 * 
	 * @return department
	 */
	static String getDepartmentName() {
		LOGGER.info("Enter Department Name (ECE, EEE, CIVIL, MECH, CSE)\nPress # To Exit");
		final String departmentName = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(departmentName)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkDepartmentName(departmentName)) {
			return departmentName;
		} else {
			LOGGER.warn("Enter Valid Department:\nPress # To Exit");
			return StudentView.getDepartmentName();
		}
	}

	/**
	 * Get student gender.
	 * 
	 * @return Gender
	 */
	static String getGender() {
		LOGGER.info("Enter Student Gender (Male or Female or Others)\nPress # To Exit");
		final String gender = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(gender)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkGender(gender)) {
			return gender;
		} else {
			LOGGER.warn("Enter Valid Gender:\nPress # To Exit");
			return StudentView.getGender();
		}
	}

	/**
	 * Get student Date-of-birth.
	 * 
	 * @return DOB
	 */
	static Date getDateOfBirth() {
		LOGGER.info("Enter Student Date-of-Birth (yyyy-MM-dd)\nPress # To Exit");
		final String date = StudentView.SCANNER.nextLine();

		if ("#".equals(date)) {
			StudentInformationView.showAdminWorks();
		}
		boolean isValidDate = false;

		try {
			isValidDate = STUDENTRECORD_CONTROLLER.checkDateOfBirth(date);
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}

		if (isValidDate) {
			return Date.valueOf(date);
		} else {
			LOGGER.warn("Enter Valid Date:\nPress # To Exit");
			return StudentView.getDateOfBirth();
		}
	}

	/**
	 * Get the address of the student.
	 * 
	 * @return Address
	 */
	static String getAddress() {
		LOGGER.info("Enter Student Address:\nPress # To Exit");
		final String address = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(address)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkAddress(address)) {
			return address;
		} else {
			LOGGER.warn("Enter Valid Address:\nPress # To Exit");
			return StudentView.getAddress();
		}
	}

	/**
	 * Get grade of the student.
	 * 
	 * @return grade
	 */
	static String getGrade() {
		LOGGER.info("Enter Student Grade:(O, A, A+, B, U)\nPress # To Exit");
		final String grade = StudentView.SCANNER.nextLine().trim();

		if ("#".equals(grade)) {
			StudentInformationView.showAdminWorks();
		}

		if (STUDENTRECORD_CONTROLLER.checkGrade(grade)) {
			return grade;
		} else {
			LOGGER.warn("Enter Valid Grade:\nPress # To Exit");
			return StudentView.getGrade();
		}
	}

	/**
	 * Get the credential to signup.
	 */
	public static void adminSignup() {
		final String adminName = StudentView.getName();
		final String adminEmail = StudentView.getEmail();
		final String password = StudentView.getPassword();

		try {

			if (STUDENTRECORD_CONTROLLER.adminSignup(adminName, adminEmail, password)) {
				LOGGER.info("Admin Details Inserted Successfully");
				StudentView.adminLogin();
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}

	/**
	 * Get the credential to login.
	 */
	public static void adminLogin() {
		final String adminEmail = StudentView.getEmail();
		final String password = StudentView.getPassword();

		try {

			if (STUDENTRECORD_CONTROLLER.adminLogin(adminEmail, password)) {
				LOGGER.info("Log in Successfully");
				StudentInformationView.showAdminWorks();
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}

	/**
	 * Student login to view thier respective record.
	 */
	public static void studentLogin() {
		final String rollNumber = StudentView.getStudentRollNumber();
		final String studentName = StudentView.getName();

		try {

			if (STUDENTRECORD_CONTROLLER.studentLogin(rollNumber, studentName)) {
				LOGGER.info("Login Successfully");
				StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}
}