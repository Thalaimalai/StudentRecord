package com.studentrecord.service;

import com.studentrecord.exception.CustomException.*;
import com.studentrecord.dao.StudentDAO;
import com.studentrecord.dao.StudentDAOImpl;
import com.studentrecord.model.Student;

/**
 * StudentServiceDAO.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentServiceDAOImpl implements StudentServiceDAO{

	private final StudentDAO STUDENTRECORD_DAO = new StudentDAOImpl();

	/**
	 * Check the existing admin emails.
	 * 
	 * @param adminName
	 * @param adminEmail
	 * @param password
	 */
	public boolean insertAdminDetail(final String adminName, final String adminEmail, final String password) {

		if (!STUDENTRECORD_DAO.selectAdminEmail().contains(adminEmail)) {
			final boolean isInserted = STUDENTRECORD_DAO.insertAdminDetails(adminName, adminEmail, password);

			if (isInserted) {
				return true;
			}
		}
		throw new DetailsAlreadyFoundException("Admin Details Already Exist");
	}

	/**
	 * Validate admin details for signin.
	 * 
	 * @param adminEmail
	 * @param password
	 */
	public boolean validateAdminDetail(final String adminEmail, final String password) {
		final boolean isLogin = STUDENTRECORD_DAO.loginAdmin(adminEmail, password);

		if (isLogin) {
			return true;
		} else {
			throw new RecordNotfoundException("Record Not Found");
		}
	}

	/**
	 * Validate student details for login.
	 * 
	 * @param rollNumber
	 * @param studentName
	 */
	public boolean studentLogin(final String rollNumber, final String studentName) {
		final boolean isLogin = STUDENTRECORD_DAO.studentLogin(rollNumber, studentName);

		if (isLogin) {
			return true;
		} else {
			throw new RecordNotfoundException("Record Not Found");
		}
	}

	/**
	 * Insert student details.
	 * 
	 * @param student
	 */
	public boolean insertStudentDetails(final Student student) {

		if (!STUDENTRECORD_DAO.getAllStudents().containsKey(student.getRollNumber())) {
			final boolean isInserted = STUDENTRECORD_DAO.insertStudentDetails(student);

			if (isInserted) {
				return true;
			}
		}
		throw new RollNumberAlreadyExistException("RollNumber Already Exist");
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 */
	public boolean deleteStudentDetails(final String rollNumber) {
		final boolean isRemoved = STUDENTRECORD_DAO.deleteStudentDetails(rollNumber);

		if (isRemoved) {
			return true;
		}
		throw new RecordNotfoundException("Record Not Found");
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 */
	public boolean updateStudentDetails(final Student student) {
		final boolean isUpdated = STUDENTRECORD_DAO.updateStudentDetails(student);

		if (isUpdated) {
			return true;
		}
		throw new RecordNotfoundException("Record Not Found");
	}

	/**
	 * Get student detail.
	 * 
	 * @param rollNumber
	 */
	public Student selectStudentDetail(final String rollNumber) {

		if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
			return STUDENTRECORD_DAO.selectStudentDetail(rollNumber);
		} else {
			throw new RecordNotfoundException("Record Not Found");
		}
	}

	public boolean checkRollNumber(final String rollNumber) {
		final boolean isRollNumberPresent = STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber);
		
		if (!isRollNumberPresent) {
            return true;
        }
        throw new RollNumberAlreadyExistException("The Given Rollnumber Already Exist\n Re-Enter RollNo ");
	}
}