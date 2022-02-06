package com.studentrecord.dao;

import java.util.List;
import com.studentrecord.model.Student;

public interface StudentRecordDAO {
	boolean studentLogin(final String rollNumber, final String studentName);

	boolean insertStudentDetails(final Student student);

	boolean viewStudentDetails(final String rollNumber);

	boolean deleteStudentDetails(final String rollNumber);

	boolean updateStudentDetails(final Student student);
	
	void insertAdminSignup(final String adminName, final String adminEmail, final String password);	
	
	List<String> selectAdminEmail();
}

