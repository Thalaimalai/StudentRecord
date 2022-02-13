package com.studentrecord.controller;

import com.studentrecord.model.Student;
import com.studentrecord.service.StudentService;
import com.studentrecord.service.StudentServiceDAO;
import com.studentrecord.service.StudentServiceDAOImpl;
import com.studentrecord.service.StudentServiceImpl;

/**
 * StudentManagementController. Controls all the requests and responses
 * from the user to the services and vice versa.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {
	
	private static final StudentService STUDENT_SERVICES = new StudentServiceImpl();
	private static final StudentServiceDAO STUDENT_SERVICE_DAO = new StudentServiceDAOImpl();
	
	public boolean choice(final String choice) {
		return STUDENT_SERVICES.validateChoice(choice);
	}
	
	public boolean name(final String name) {
		return STUDENT_SERVICES.validateName(name);
	}

	public boolean email(final String email) {
		return STUDENT_SERVICES.validateEmail(email);
	}

	public boolean adminPassword(final String password) {
		return STUDENT_SERVICES.validateAdminPassword(password);
	}

	public boolean studentRollNumber(final String rollNumber) {
		return STUDENT_SERVICES.validateStudentRollNumber(rollNumber);
	}

	public boolean departmentName(final String departmentName) {
		return STUDENT_SERVICES.validateDepartmentName(departmentName);
	}

	public boolean gender(final String gender) {
		return STUDENT_SERVICES.validateGender(gender);
	}

	public boolean dateOfBirth(final String dateOfBirth) {
		return STUDENT_SERVICES.validateDOB(dateOfBirth);
	}

	public boolean address(final String address) {
		return STUDENT_SERVICES.validateAddress(address);
	}
	
	public boolean grade(final String grade) {
		return STUDENT_SERVICES.validateGrade(grade);
	}
	
	public boolean adminSignup(final String adminName, final String adminEmail, final String password) {
		return STUDENT_SERVICE_DAO.insertAdminDetail(adminName, adminEmail, password);
	}

	public boolean adminLogin(final String adminEmail, final String password) {
		return STUDENT_SERVICE_DAO.validateAdminDetail(adminEmail, password);
	}

	public boolean studentLogin(final String rollNumber, final String studentName) {
		return STUDENT_SERVICE_DAO.studentLogin(rollNumber, studentName);
	}

	public boolean insertStudentDetails(final Student student) {
		return STUDENT_SERVICE_DAO.insertStudentDetails(student);
	}

	public Student selectStudentDetail(final String rollNumber) {
		return STUDENT_SERVICE_DAO.selectStudentDetail(rollNumber);
	}

	public boolean deleteStudentDetails(final String rollNumber) {
		return STUDENT_SERVICE_DAO.deleteStudentDetails(rollNumber);
	}

	public boolean updateStudentDetails(final Student student) {
		return STUDENT_SERVICE_DAO.updateStudentDetails(student);
	}

	public boolean checkRollNumber(final String rollNumber) {
		return STUDENT_SERVICE_DAO.checkRollNumber(rollNumber);
	}
}