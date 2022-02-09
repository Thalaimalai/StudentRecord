package com.studentrecord.view;

import java.sql.Date;
import com.studentrecord.controller.StudentRecordController;
import com.studentrecord.exception.CustomException;
import com.studentrecord.exception.CustomException.RecordNotfoundException;
import com.studentrecord.model.Student;

public class StudentInformation {
	
	private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
	
	/**
	 * Admin duties for modification of the student records.
	 */
    public static void showAdminWorks() {
		
	   	do {
			System.out.println("1.Insert 2.View 3.Delete 4.Update");

			try {
				int choice = Integer.parseInt(StudentRecordInformation.SCANNER.nextLine());

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
				System.out.println("Enter Valid Choice");
			}
		} while (true);
	}

	/**
	 * Get the information of students to insert.
	 */
	private static void insertStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		final String studentName = StudentRecordInformation.getName();
		final String departmentName = StudentRecordInformation.getDepartmentName();
		final String email = StudentRecordInformation.getEmail();
		final String gender = StudentRecordInformation.getGender();
		final Date dateOfBirth = StudentRecordInformation.getDateOfBirth();
		final String address = StudentRecordInformation.getAddress();

		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address);
		
		try {
			final boolean isInserted = STUDENTRECORD_CONTROLLER.insertStudentDetails(student);
			
			if (isInserted) {
				System.out.println("Record Inserted Successfully");
			}
		} catch (CustomException exception) {
			System.out.println(exception);
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
			System.out.println(exception);
		}
	}
	
	/**
	 * Print the student details.
	 * 
	 * @param student
	 */
	public static void showDetails(final Student student) {
        System.out.println(student);
    }

	/**
	 * Delete the student records.
	 */
	private static void deleteStudentDetails() {
		final String rollNumber = StudentRecordInformation.getStudentRollNumber();
		
		try {
			final boolean isDeleted = STUDENTRECORD_CONTROLLER.deleteStudentDetails(rollNumber);
		
			if (isDeleted) {
				System.out.println("Record Deleted Successfully");
			}
		} catch (CustomException exception) {
			System.out.println(exception);
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

		final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address);
		
		try {
			final boolean isUpdated = STUDENTRECORD_CONTROLLER.updateStudentDetails(student);
			
			if (isUpdated) {
				System.out.println("Record Updated Successfully");
			}
		} catch (CustomException exception) {
			System.out.println(exception);
		}
	}
}