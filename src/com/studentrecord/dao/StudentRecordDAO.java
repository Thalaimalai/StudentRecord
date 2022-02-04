package com.studentrecord.dao;

import java.util.List;
import com.studentrecord.model.Student;

public interface StudentRecordDAO {
	void studentLogin(final String rollNumber, final String studentName);

	void insertStudentDetails(final Student student);

	void viewStudentDetails(final String rollNumber);

	void deleteStudentDetails(final String rollNumber);

	void updateStudentDetails(final Student student);
	
	void insertAdminSignup(final String adminName, final String adminEmail, final String password);	
	
	List<String> selectAdminEmail();
}

