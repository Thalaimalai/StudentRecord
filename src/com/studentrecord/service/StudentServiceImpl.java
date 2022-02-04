package com.studentrecord.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.dao.StudentRecordDAO;
import com.studentrecord.dao.StudentRecordDAOImpl;
import com.studentrecord.model.Student;
import com.studentrecord.view.StudentRecordInformation;

/**
 * <h1>StudentRecordServiceImpl</h>
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceImpl implements StudentService {
	private static final StudentRecordDAO STUDENTRECORD_DAO = new StudentRecordDAOImpl();

	/**
	 * Validate Name.
	 * 
	 * @param name
	 */
	public String validateName(final String name) {

		if (!name.matches("^([a-zA-Z]+\\s)*[a-zA-Z]+$|^[a-zA-Z]$")) {
			System.out.println("Please Enter Valid Name");

			return StudentRecordInformation.getAdminName();
		}
		return name;
	}

	/**
	 * Validate Email.
	 * 
	 * @param Email
	 */
	public String validateEmail(final String email) {

		if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/]+@[a-zA-Z0-9.-]+$")) {
			System.out.println("Please Enter Valid Email");

			return StudentRecordInformation.getEmail();
		}
		return email;
	}

	/**
	 * Validate Password.
	 * 
	 * @param Password
	 */
	public String validateAdminPassword(final String password) {

		if (!password.matches("^(?=.*[a-zA-Z0-9@#$%^&+=])(?=\\S+$).{8,}$")) {
			System.out.println("Please Enter Valid Password");

			return StudentRecordInformation.getPassword();
		}
		return password;
	}

	/**
	 * Validate Rollnumber.
	 * 
	 * @param name
	 */
	public String validateStudentRollNumber(final String rollNumber) {

		if (!(rollNumber.matches("[0-9]{3,15}"))) {
			System.out.println("Please Enter Valid Roll Number");

			return StudentRecordInformation.getStudentRollNumber();
		}
		return rollNumber;
	}

	/**
	 * Validate Student name.
	 * 
	 * @param Name
	 */
	public String validateStudentName(final String studentName) {

		if (!studentName.matches("^([a-zA-Z]+\\s)*[a-zA-Z]+$|^[a-zA-Z]$")) {
			System.out.println("Please Enter Valid Name");

			return StudentRecordInformation.getStudentName();
		}
		return studentName;
	}

	/**
	 * Validate Department Name.
	 * 
	 * @param Department name
	 */
	public String validateDepatementName(final String departmentName) {

		if (!departmentName.matches("^[a-zA-Z\\s]*$")) {
			System.out.println("Please Enter Valid Department");

			return StudentRecordInformation.getDepartmentName();
		}
		return departmentName;
	}

	/**
	 * Validate Gender.
	 * 
	 * @param Gender
	 */
	public String validateGender(final String gender) {

		if (!(gender.matches("^M(ale)?$|^F(emale)?$"))) {
			System.out.println("Please Enter Valid Gender");

			return StudentRecordInformation.getGender();
		}
		return gender;
	}

	/**
	 * Validate Date-of-Birth.
	 * 
	 * @param DOB
	 */
	public Date validateDOB(final String dateOfBirth) {
		Date sqlDate;

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			java.util.Date date = dateFormat.parse(dateOfBirth);
			sqlDate = new Date(date.getTime());
		} catch (Exception exception) {
			System.out.println("Please enter valid date");

			return StudentRecordInformation.getDateOfBirth();
		}
		return sqlDate;
	}

	/**
	 * Validate Address.
	 * 
	 * @param Address
	 */
	public String validateAddress(final String address) {

		if (!address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*")) {
			System.out.println("Please Enter Valid Address");

			return StudentRecordInformation.getAddress();
		}
		return address;
	}

	public static void showAdminWorks() {
		StudentRecordController.showAdminWorks();
	}

	/**
	 * Student Login.
	 */
	public void studentLogin(final String rollNumber, final String studentName) {
		STUDENTRECORD_DAO.studentLogin(rollNumber, studentName);
	}

	/**
	 * Insert the student records.
	 */
	public void insertStudentDetails(final Student student) {
		STUDENTRECORD_DAO.insertStudentDetails(student);
	}

	/**
	 * View the student records.
	 */
	public void viewStudentDetails(final String rollNumber) {
		STUDENTRECORD_DAO.viewStudentDetails(rollNumber);
	}

	/**
	 * Delete the student records.
	 */
	public void deleteStudentDetails(final String rollNumber) {
		STUDENTRECORD_DAO.deleteStudentDetails(rollNumber);
	}

	/**
	 * Update the students records.
	 */
	public void updateStudentDetails(final Student student) {
		STUDENTRECORD_DAO.updateStudentDetails(student);
	}
}
