package com.studentrecord.controller;

import java.sql.Date;
import com.studentrecord.model.Student;
import com.studentrecord.service.StudentService;
import com.studentrecord.service.StudentServiceDAO;
import com.studentrecord.service.StudentServiceImpl;
import com.studentrecord.view.StudentRecordInformation;

/**
 * <h1>StudentManagementController</h1> Controls all the requests and responses
 * from the user to the services and vice versa.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {
	private static final StudentService STUDENT_SERVICES = new StudentServiceImpl();
	private static final StudentServiceDAO SERVICE_VALIDATE = new StudentServiceDAO();

	public String adminName(final String name) {
		return STUDENT_SERVICES.validateName(name);
	}

	public String email(final String email) {
		return STUDENT_SERVICES.validateEmail(email);
	}

	public String adminPassword(final String password) {
		return STUDENT_SERVICES.validateAdminPassword(password);
	}

	public String studentRollNumber(final String rollNumber) {
		return STUDENT_SERVICES.validateStudentRollNumber(rollNumber);
	}

	public String departmentName(final String departmentName) {
		return STUDENT_SERVICES.validateDepatementName(departmentName);
	}

	public String studentName(final String studentName) {
		return STUDENT_SERVICES.validateStudentName(studentName);
	}

	public String getGender(final String gender) {
		return STUDENT_SERVICES.validateGender(gender);
	}

	public Date getDateOfBirth(final String dateOfBirth) {
		return STUDENT_SERVICES.validateDOB(dateOfBirth);
	}

	public String getAddress(final String address) {
		return STUDENT_SERVICES.validateAddress(address);
	}

	public void adminSignup(final String adminName, final String adminEmail, final String password) {
		SERVICE_VALIDATE.insertAdminDetail(adminName, adminEmail, password);
	}

	public void adminLogin(final String adminEmail, final String password) {
		SERVICE_VALIDATE.validateAdminDetail(adminEmail, password);
	}

	public void studentLogin(final String rollNumber, final String studentName) {
		SERVICE_VALIDATE.studentLogin(rollNumber, studentName);
	}

	public static void showAdminWorks() {
		StudentRecordInformation.showAdminWorks();
	}

	public void insertStudentDetails(final Student student) {
		SERVICE_VALIDATE.insertStudentDetails(student);
	}

	public void viewStudentDetails(final String rollNumber) {
		STUDENT_SERVICES.viewStudentDetails(rollNumber);
	}

	public void deleteStudentDetails(final String rollNumber) {
		SERVICE_VALIDATE.deleteStudentDetails(rollNumber);
	}

	public void updateStudentDetails(Student student) {
		SERVICE_VALIDATE.updateStudentDetails(student);
	}
}
