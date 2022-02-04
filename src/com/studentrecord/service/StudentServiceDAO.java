package com.studentrecord.service;

import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.dao.StudentRecordDAO;
import com.studentrecord.dao.StudentRecordDAOImpl;

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
}