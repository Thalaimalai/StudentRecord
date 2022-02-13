package com.studentrecord.view;

import java.sql.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.exception.CustomException;
import com.studentrecord.main.StudentRecordMain;

/**
 * Get all information from the users.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordInformation {

	public static final Scanner SCANNER = new Scanner(System.in);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	private static final Logger LOGGER = Logger.getLogger(StudentRecordInformation.class);

	/**
	 * Get choice.
	 * 
	 * @return choice
	 */
	public static String getChoice() {
		LOGGER.info("Enter Choice:");
		final String choice = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(choice)) {
			StudentRecordMain.selectChoice();
		}
		final boolean isValidChoice = STUDENTRECORD_CONTROLLER.choice(choice);

		if (isValidChoice) {
			return choice;
		} else {
			LOGGER.warn("Enter Valid Choice:");
			return StudentRecordInformation.getChoice();
		}
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	static String getName() {
		LOGGER.info("Enter Name:\nPress # To Exit");
		final String name = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(name)) {
			StudentRecordMain.selectChoice();
		}
		final boolean isValidName = STUDENTRECORD_CONTROLLER.name(name);

		if (isValidName) {
			return name;
		} else {
			LOGGER.warn("Enter Valid Name:\nPress # To Exit");
			return StudentRecordInformation.getName();
		}
	}

	/**
	 * Get the Email.
	 * 
	 * @return Email
	 */
	static String getEmail() {
		LOGGER.info("Enter Email:\nPress # To Exit");
		final String email = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(email)) {
			StudentRecordMain.selectChoice();
		}
		final boolean isValidEmail = STUDENTRECORD_CONTROLLER.email(email);

		if (isValidEmail) {
			return email;
		} else {
			LOGGER.warn("Enter Valid Email:\nPress # To Exit");
			return StudentRecordInformation.getEmail();
		}
	}

	/**
	 * Get the password.
	 * 
	 * @return Password
	 */
	private static String getPassword() {
		LOGGER.info("Enter Admin Password:\nPress # To Exit");
		final String password = StudentRecordInformation.SCANNER.nextLine();

		if (("#").equals(password)) {
			StudentRecordMain.selectChoice();
		}
		final boolean isValidPassword = STUDENTRECORD_CONTROLLER.adminPassword(password);

		if (isValidPassword) {
			return password;
		} else {
			LOGGER.warn("Enter Valid Password:\nPress # To Exit");
			return StudentRecordInformation.getPassword();
		}
	}

	/**
	 * Get student roll number.
	 * 
	 * @return Roll number
	 */
	static String getStudentRollNumber() {
		LOGGER.info("Enter Student Rollnumber\nPress # To Exit");
		final String rollNumber = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(rollNumber)) {
			StudentInformation.showAdminWorks();
		}
		final boolean isValidRollNumber = STUDENTRECORD_CONTROLLER.studentRollNumber(rollNumber);

		if (isValidRollNumber) {
			return rollNumber;
		} else {
			LOGGER.warn("Enter Valid Rollnumber:\nPress # To Exit");
			return StudentRecordInformation.getStudentRollNumber();
		}
	}

	/**
	 * Get student department name.
	 * 
	 * @return department
	 */
	static String getDepartmentName() {
		LOGGER.info("Enter Department Name (ECE, EEE, CIVIL, MECH, CSE)\nPress # To Exit");
		final String departmentName = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(departmentName)) {
			StudentInformation.showAdminWorks();
		}
		final boolean isValidDepartmentName = STUDENTRECORD_CONTROLLER.departmentName(departmentName);

		if (isValidDepartmentName) {
			return departmentName;
		} else {
			LOGGER.warn("Enter Valid Department:\nPress # To Exit");
			return StudentRecordInformation.getDepartmentName();
		}
	}

	/**
	 * Get student gender.
	 * 
	 * @return Gender
	 */
	static String getGender() {
		LOGGER.info("Enter Student Gender (Male or Female or Others)\nPress # To Exit");
		final String gender = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(gender)) {
			StudentInformation.showAdminWorks();
		}
		final boolean isValidGender = STUDENTRECORD_CONTROLLER.gender(gender);

		if (isValidGender) {
			return gender;
		} else {
			LOGGER.warn("Enter Valid Gender:\nPress # To Exit");
			return StudentRecordInformation.getGender();
		}
	}

	/**
	 * Get student Date-of-birth.
	 * 
	 * @return DOB
	 */
	static Date getDateOfBirth() {
		LOGGER.info("Enter Student Date-of-Birth (yyyy-MM-dd)\nPress # To Exit");
		final String date = StudentRecordInformation.SCANNER.nextLine();

		if (("#").equals(date)) {
			StudentInformation.showAdminWorks();
		}
		boolean isValidDate = false;

		try {
			isValidDate = STUDENTRECORD_CONTROLLER.dateOfBirth(date);
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}

		if (isValidDate) {
			return Date.valueOf(date);
		} else {
			LOGGER.warn("Enter Valid Date:\nPress # To Exit");
			return StudentRecordInformation.getDateOfBirth();
		}
	}

	/**
	 * Get the address of the student.
	 * 
	 * @return Address
	 */
	static String getAddress() {
		LOGGER.info("Enter Student Address:\nPress # To Exit");
		final String address = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(address)) {
			StudentInformation.showAdminWorks();
		}
		final boolean isValidAddress = STUDENTRECORD_CONTROLLER.address(address);

		if (isValidAddress) {
			return address;
		} else {
			LOGGER.warn("Enter Valid Address:\nPress # To Exit");
			return StudentRecordInformation.getAddress();
		}
	}

	/**
	 * Get grade of the student.
	 * 
	 * @return grade
	 */
	static String getGrade() {
		LOGGER.info("Enter Student Grade:(O, A, A+, B, U)\nPress # To Exit");
		final String grade = StudentRecordInformation.SCANNER.nextLine().trim();

		if (("#").equals(grade)) {
			StudentInformation.showAdminWorks();
		}
		final boolean isValidGrade = STUDENTRECORD_CONTROLLER.grade(grade);

		if (isValidGrade) {
			return grade;
		} else {
			LOGGER.warn("Enter Valid Grade:\nPress # To Exit");
			return StudentRecordInformation.getGrade();
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
				LOGGER.info("Admin Details Inserted Successfully");
				StudentRecordInformation.adminLogin();
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}

	/**
	 * Get the credential to login.
	 */
	public static void adminLogin() {
		final String adminEmail = StudentRecordInformation.getEmail();
		final String password = StudentRecordInformation.getPassword();

		try {
			final boolean isLogin = STUDENTRECORD_CONTROLLER.adminLogin(adminEmail, password);

			if (isLogin) {
				LOGGER.info("Log in Successfully");
				StudentInformation.showAdminWorks();
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}

	/**
	 * Student login to view thier respective record.
	 */
	public static void studentLogin() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getName();

		try {
			final boolean isLogin = STUDENTRECORD_CONTROLLER.studentLogin(rollNumber, studentName);

			if (isLogin) {
				LOGGER.info("Login Successfully");
				StudentInformation.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}
}