/**
 * 
 */
package com.studentrecord.service;

import java.sql.Date;

import com.studentrecord.model.Student;

public interface StudentService {
	void studentLogin(final String rollNumber, final String studentName);

	void insertStudentDetails(final Student student);

	void viewStudentDetails(final String rollNumber);

	void deleteStudentDetails(final String rollNumber);

	void updateStudentDetails(final Student student);

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
