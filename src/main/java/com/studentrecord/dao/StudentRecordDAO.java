package com.studentrecord.dao;

import java.util.List;
import java.util.Map;

import com.studentrecord.model.Student;

public interface StudentRecordDAO {
	boolean studentLogin(final String rollNumber, final String studentName);

	boolean insertStudentDetails(final Student student);

	boolean deleteStudentDetails(final String rollNumber);

	boolean updateStudentDetails(final Student student);
	
	Student selectStudentDetail(final String rollNumber);
	
	boolean insertAdminDetails(final String adminName, final String adminEmail, final String password);	
	
	List<String> selectAdminEmail();

	Map<String, Student> getAllStudents();
}
