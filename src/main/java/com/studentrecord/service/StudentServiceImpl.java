package com.studentrecord.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.dao.StudentRecordDAO;
import com.studentrecord.dao.StudentRecordDAOImpl;
import com.studentrecord.view.StudentRecordInformation;

/**
 * <h1>StudentRecordServiceImpl</h>
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceImpl implements StudentService {
	
	/**
	 * Validate Name.
	 * 
	 * @param name
	 */
	public boolean validateName(final String name) {

		if (!name.matches("^[a-zA-Z+\\s]*$")) {
			System.out.println("Please Enter Valid Name");
			
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Email.
	 * 
	 * @param Email
	 */
	public boolean validateEmail(final String email) {

		if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]+$")) {
			System.out.println("Please Enter Valid Email");

			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Password.
	 * 
	 * @param Password
	 */
	public boolean validateAdminPassword(final String password) {

		if (!password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}")) {
			System.out.println("Please Enter Valid Password");
			
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Rollnumber.
	 * 
	 * @param name
	 */
	public boolean validateStudentRollNumber(final String rollNumber) {

		if (!(rollNumber.matches("[0-9]{3,15}"))) {
			System.out.println("Please Enter Valid Roll Number");

			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Department Name.
	 * 
	 * @param Department name
	 */
	public boolean validateDepartmentName(final String departmentName) {

		if (!departmentName.matches("^[a-zA-Z\\s]*$")) {
			System.out.println("Please Enter Valid Department");
			
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Gender.
	 * 
	 * @param Gender
	 */
	public boolean validateGender(final String gender) {

		if (!(gender.matches("^M(ale)?$|^F(emale)?$"))) {
			System.out.println("Please Enter Valid Gender");

			return false;
		} else {
			return true;
		}
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
	public boolean validateAddress(final String address) {

		if (!address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*")) {
			System.out.println("Please Enter Valid Address");

			return false;
		} else {
			return true;
		}
	}
}
