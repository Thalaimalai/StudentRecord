package com.studentrecord.service;

import java.sql.Date;

public interface StudentService {
	boolean validateName(final String name);

	boolean validateEmail(final String email);

	boolean validateAdminPassword(final String password);

	boolean validateStudentRollNumber(final String rollNumber);

	boolean validateDepartmentName(final String departmentName);

	boolean validateGender(final String gender);

	Date validateDOB(final String dateOfBirth);

	boolean validateAddress(final String address);
}

