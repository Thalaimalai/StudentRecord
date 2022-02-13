package com.studentrecord.view;

import java.sql.Date;
import org.apache.log4j.Logger;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.exception.CustomException;
import com.studentrecord.exception.CustomException.RecordNotfoundException;
import com.studentrecord.model.Student;

public class StudentInformation {
	
	private static final Logger LOGGER = Logger.getLogger(StudentInformation.class);
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	
	/**
	 * Admin duties for modification of the student records.
	 */
    public static void showAdminWorks() {
		
	   	do {
			LOGGER.info("1.Insert 2.View 3.Delete 4.Update 5.Exit");

			try {
				int choice = Integer.parseInt(StudentRecordInformation.getChoice().trim());

				if (choice == 1) {
					StudentInformation.insertStudentDetails();
				} else if (choice == 2) {
					StudentInformation.viewStudentDetails();
				} else if (choice == 3) {
					StudentInformation.deleteStudentDetails();
				} else if (choice == 4) {
					StudentInformation.updateStudentDetails();
				} else {
					StudentRecordInformation.SCANNER.close();
					System.exit(0);
				}
			} catch (NumberFormatException exception) {
				LOGGER.error("Enter Valid Choice");
			}
		} while (true);
	}

	/**
	 * Get the information of students to insert.
	 */
	private static void insertStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		
		try {
			STUDENTRECORD_CONTROLLER.checkRollNumber(rollNumber);
		} catch (CustomException exception) {
			LOGGER.error(exception);
			StudentInformation.insertStudentDetails();
			StudentInformation.showAdminWorks();
		}
		final String studentName = StudentRecordInformation.getName();
		final String departmentName = StudentRecordInformation.getDepartmentName();
		final String email = StudentRecordInformation.getEmail();
		final String gender = StudentRecordInformation.getGender();
		final Date dateOfBirth = StudentRecordInformation.getDateOfBirth();
		final String address = StudentRecordInformation.getAddress();
		final String grade = StudentRecordInformation.getGrade(); 

		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);
		
		try {
			final boolean isInserted = STUDENTRECORD_CONTROLLER.insertStudentDetails(student);
			
			if (isInserted) {
				LOGGER.info("Record Inserted Successfully");
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}

	/**
	 * View the respective student records.
	 */
	private static void viewStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		
		try {
			StudentInformation.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
		} catch (RecordNotfoundException exception) {
			LOGGER.error(exception);
		}
	}
	
	/**
	 * Print the student details.
	 * 
	 * @param student
	 */
	static void showDetails(final Student student) {
        LOGGER.info(student);
    }

	/**
	 * Delete the student records.
	 */
	private static void deleteStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		
		try {
			final boolean isDeleted = STUDENTRECORD_CONTROLLER.deleteStudentDetails(rollNumber);
		
			if (isDeleted) {
				LOGGER.info("Record Deleted Successfully");
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}

	/**
	 * Update the student records.
	 */
	private static void updateStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getName();
		final String departmentName = StudentRecordInformation.getDepartmentName();
		final String email = StudentRecordInformation.getEmail();
		final String gender = StudentRecordInformation.getGender();
		final Date dateOfBirth = StudentRecordInformation.getDateOfBirth();
		final String address = StudentRecordInformation.getAddress();
		final String grade = StudentRecordInformation.getGrade();
		
		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);
		
		try {
			final boolean isUpdated = STUDENTRECORD_CONTROLLER.updateStudentDetails(student);
			
			if (isUpdated) {
				LOGGER.info("Record Updated Successfully");
			}
		} catch (CustomException exception) {
			LOGGER.error(exception);
		}
	}
}