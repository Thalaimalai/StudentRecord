package com.studentrecord.dao;

import com.studentrecord.model.Admin;
import com.studentrecord.model.Student;

public interface StudentRecordDAO {
	void insertAdminSignup(Admin admin);
	
	void getAdminLogin(final String adminEmail, final String password);
	
	void studentLogin(final String rollNumber, final String studentName);

	void insertStudentDetails(Student student);

	void viewStudentDetails(String rollNumber);

	void deleteStudentDetails(String rollNumber);
}
