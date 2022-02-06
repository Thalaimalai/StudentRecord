package com.studentrecord.service;

import java.sql.Date;

public interface StudentService {
	void viewStudentDetails(final String rollNumber);

	String validateName(final String name);

	String validateEmail(final String email);

	String validateAdminPassword(final String password);

	String validateStudentRollNumber(final String rollNumber);

	String validateStudentName(final String studentName);

	String validateDepatementName(final String departmentName);

	String validateGender(final String gender);

	Date validateDOB(final String dateOfBirth);

	String validateAddress(final String address);
}
