package com.studentrecord.service;

import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.dao.StudentRecordDAO;
import com.studentrecord.dao.StudentRecordDAOImpl;
import com.studentrecord.model.Student;

/**
 * <h1>StudentServiceDAO
 * <h1>
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceDAO {
	private final StudentRecordDAO STUDENTRECORD_DAO = new StudentRecordDAOImpl();

	/**
	 * Check the existing admin emails.
	 * 
	 * @param adminName
	 * @param adminEmail
	 * @param password
	 * @return password
	 */
	public String insertAdminDetail(final String adminName, final String adminEmail, final String password) {

		if (!STUDENTRECORD_DAO.selectAdminEmail().contains(adminEmail)) {
			STUDENTRECORD_DAO.insertAdminSignup(adminName, adminEmail, password);
		} else {
			System.out.println("Already exist");
		}
		return adminEmail;
	}

	/**
	 * Validate admin details for signin.
	 * 
	 * @param adminEmail
	 * @param password
	 */
	public void validateAdminDetail(final String adminEmail, final String password) {

		if (STUDENTRECORD_DAO.selectAdminEmail().contains(adminEmail)) {
			System.out.println("Login Successfully");

			StudentRecordController.showAdminWorks();
		} else {
			System.out.println("Invalid Data");
		}
	}

	/**
	 * Validate student details for login.
	 * 
	 * @param rollNumber
	 * @param studentName
	 */
	public void studentLogin(final String rollNumber, final String studentName) {

		if (STUDENTRECORD_DAO.studentLogin(rollNumber, studentName)) {
			System.out.println("Login Successfully");

			STUDENTRECORD_DAO.viewStudentDetails(rollNumber);
		} else {
			System.out.println("Invalid Data");
		}
	}

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public void insertStudentDetails(Student student) {

		if (STUDENTRECORD_DAO.insertStudentDetails(student)) {
			System.out.println("Data Inserted Successfully");
		} else {
			System.out.println("Data Not Entered");
		}
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 */
	public void deleteStudentDetails(String rollNumber) {

		if (STUDENTRECORD_DAO.deleteStudentDetails(rollNumber)) {
			System.out.println("Record Deleted Successfully");
		} else {
			System.out.println("Record Not Deleted");
		}
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public void updateStudentDetails(Student student) {

		if (STUDENTRECORD_DAO.updateStudentDetails(student)) {
			System.out.println("Data Inserted Successfully");
		} else {
			System.out.println("Data Not Entered");
		}
	}
}