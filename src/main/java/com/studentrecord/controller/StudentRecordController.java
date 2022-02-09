package com.studentrecord.controller;

import java.sql.Date;
import com.studentrecord.model.Student;
import com.studentrecord.service.StudentService;
import com.studentrecord.service.StudentServiceDAO;
import com.studentrecord.service.StudentServiceImpl;

/**
 * <h1>StudentManagementController</h1> Controls all the requests and responses
 * from the user to the services and vice versa.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordController {
	
	private static final StudentService STUDENT_SERVICES = new StudentServiceImpl();
	private static final StudentServiceDAO STUDENT_SERVICE_DAO = new StudentServiceDAO();

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

	public Date dateOfBirth(final String dateOfBirth) {
		return STUDENT_SERVICES.validateDOB(dateOfBirth);
	}

	public boolean address(final String address) {
		return STUDENT_SERVICES.validateAddress(address);
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

	public boolean updateStudentDetails(Student student) {
		return STUDENT_SERVICE_DAO.updateStudentDetails(student);
	}
}
