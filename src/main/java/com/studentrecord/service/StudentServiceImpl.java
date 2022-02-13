package com.studentrecord.service;

import java.time.LocalDate;
import com.studentrecord.exception.CustomException.DateNotValidException;

/**
 * StudentRecordServiceImpl.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceImpl implements StudentService {

	public boolean validateChoice(String choice) {

		if (!choice.matches("[1-5]")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Name.
	 * 
	 * @param name
	 */
	public boolean validateName(final String name) {

		if (!name.matches("^[A-Z][A-Za-z+\\s]*$")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Email.
	 * 
	 * @param email
	 */
	public boolean validateEmail(final String email) {

		if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]+$")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Password.
	 * 
	 * @param password
	 */
	public boolean validateAdminPassword(final String password) {

		if (!password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Rollnumber.
	 * 
	 * @param rollNumber
	 */
	public boolean validateStudentRollNumber(final String rollNumber) {

		if (!(rollNumber.matches("[0-9]{3,15}"))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Department Name.
	 * 
	 * @param departmentName
	 */
	public boolean validateDepartmentName(final String departmentName) {

		if (!("ECE".equalsIgnoreCase(departmentName) || "EEE".equalsIgnoreCase(departmentName)
				|| "MECH".equalsIgnoreCase(departmentName) || "CSE".equalsIgnoreCase(departmentName)
				|| "CIVIL".equalsIgnoreCase(departmentName))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Gender.
	 * 
	 * @param gender
	 */
	public boolean validateGender(final String gender) {

		if (!("MALE".equalsIgnoreCase(gender) || "FEMALE".equalsIgnoreCase(gender)
				|| "OTHERS".equalsIgnoreCase(gender))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validate Date-of-Birth.
	 * 
	 * @param dateOfBirth
	 */
	public boolean validateDOB(final String dateOfBirth) {

		try {
			final LocalDate dateParse = LocalDate.parse(dateOfBirth);
			final LocalDate todayDate = LocalDate.now();
			LocalDate particularDate = LocalDate.of(1980, 12, 31);

			if ((todayDate.isAfter(dateParse)) && (dateParse.isAfter(particularDate))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			throw new DateNotValidException("Invalid Date");
		}
	}

	/**
	 * Validate Address.
	 * 
	 * @param address
	 */
	public boolean validateAddress(final String address) {

		if (!address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validateGrade(final String grade) {

		if (!("A".equalsIgnoreCase(grade) || "A+".equalsIgnoreCase(grade) || "O".equalsIgnoreCase(grade)
				|| "B".equalsIgnoreCase(grade) || "U".equalsIgnoreCase(grade))) {
			return false;
		} else {
			return true;
		}
	}
}