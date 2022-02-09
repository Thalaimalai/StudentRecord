package com.studentrecord.service;

import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.exception.CustomException.*;
import com.studentrecord.dao.StudentRecordDAO;
import com.studentrecord.dao.StudentRecordDAOImpl;
import com.studentrecord.model.Student;

/**
 * <h1>StudentServiceDAO</h1>
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
	public boolean insertAdminDetail(final String adminName, final String adminEmail, final String password) {

		if (!STUDENTRECORD_DAO.selectAdminEmail().contains(adminEmail)) {
			boolean isInserted = STUDENTRECORD_DAO.insertAdminDetails(adminName, adminEmail, password);
			
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
	 * @return 
	 */
	public boolean validateAdminDetail(final String adminEmail, final String password) {

		if (STUDENTRECORD_DAO.selectAdminEmail().contains(adminEmail)) {
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
	 * @return 
	 */
	public boolean studentLogin(final String rollNumber, final String studentName) {
		boolean isLogin = STUDENTRECORD_DAO.studentLogin(rollNumber, studentName); 
		
		if(isLogin) {
			return true;
		}
		else {
			throw new RecordNotfoundException("Record Not Found");
        }
	}

	/**
	 * Insert student details.
	 * 
	 * @param student
	 * @return 
	 */
	public boolean insertStudentDetails(Student student) {
		final boolean isInserted = STUDENTRECORD_DAO.insertStudentDetails(student);
		
		if(isInserted) {
			return true;
		}
		throw new RollNumberAlreadyFoundException("RollNumber Already Exist");
	}

	/**
	 * Delete student details.
	 * 
	 * @param rollNumber
	 * @return 
	 */
	public boolean deleteStudentDetails(String rollNumber) {

		final boolean isRemoved = STUDENTRECORD_DAO.deleteStudentDetails(rollNumber);
		
		if(isRemoved) {
			return true;
		} 
		throw new RecordNotfoundException ("Record Not Found");
	}

	/**
	 * Update student details.
	 * 
	 * @param student
	 * @return 
	 */
	public boolean updateStudentDetails(Student student) {

		final boolean isUpdated = STUDENTRECORD_DAO.updateStudentDetails(student);
		
		if(isUpdated) {
			return true;
		} 
		throw new RecordNotfoundException ("Record Not Found");
	}

	/**
	 * Get student detail.
	 * 
	 * @param rollNumber
	 * @return
	 */
	public Student selectStudentDetail(String rollNumber) {
		
		if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
            return STUDENTRECORD_DAO.selectStudentDetail(rollNumber);
        } else {
			throw new RecordNotfoundException("Record Not Found");
        }
	}
}
