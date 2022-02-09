package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.Date;

import com.studentrecord.exception.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.studentrecord.model.Student;
import com.studentrecord.exception.CustomException.AccessFailedException;

/**
 * <h1>StudentRecordDAOImpl</h1>
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordDAOImpl implements StudentRecordDAO {

	/**
	 * Insert the Admin informations.
	 * 
	 * @param Admin name
	 * @param Admin email
	 * @param Admin password
	 * 
	 */
	public boolean insertAdminDetails(final String adminName, final String adminEmail, final String password) {
		final String insertQuery = "insert into admin_records values(?,?,?)";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setString(1, adminName);
			statement.setString(2, adminEmail);
			statement.setString(3, password);

			return statement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new AccessFailedException ("Database Access Denied");
		}
	}

	/**
	 * Student login.
	 * 
	 * @param Rollnumber
	 * @param Student name
	 */
	public boolean studentLogin(final String rollNumber, final String studentName) {
		final String studentLogin = "select rollnumber, name from student_records where rollnumber=? and name=? ";
		
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(studentLogin);) {
			preparestatement.setString(1, rollNumber);
			preparestatement.setString(2, studentName);
			
			try(ResultSet resultset = preparestatement.executeQuery();) {
				
				while(resultset.next()) {
				 return true;
				}
			}
		} catch (SQLException exception) {
			throw new AccessFailedException ("Database Access Denied");
		}
		return false;
	}

	/**
	 * Insert student details.
	 * 
	 * @param Student student
	 */
	public boolean insertStudentDetails(final Student student) {
		final String insertQuery = "insert into student_records values(?,?,?,?,?,?,?)";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(insertQuery);) {

			preparestatement.setString(1, student.getRollNumber());
			preparestatement.setString(2, student.getName());
			preparestatement.setString(3, student.getDepartmentName());
			preparestatement.setString(4, student.getEmail());
			preparestatement.setString(5, student.getGender());
			preparestatement.setDate(6, student.getDateOfBirth());
			preparestatement.setString(7, student.getAddress());

			return preparestatement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new AccessFailedException ("Database Access Denied");
		}
	}

	/**
	 * Get student records.
	 * 
	 * @param Rollnumber
	 */
	public  Student selectStudentDetail (final String rollNumber) {
		final String getQuery = "select * from student_records where rollnumber = ?";
		Student student = null;
		
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(getQuery);) {
			preparestatement.setString(1, rollNumber);
			
			try(ResultSet resultset = preparestatement.executeQuery();){
				
				while (resultset.next()) {
					String studentName = resultset.getString(2);
					String departmentName = resultset.getString(3);
					String email = resultset.getString(4);
					String gender = resultset.getString(5);
					Date dateOfBirth = resultset.getDate(6);
					String address = resultset.getString(7);
				
					student = new Student (rollNumber, studentName, departmentName, email, gender, dateOfBirth, address);
				}
			}
		} catch (SQLException exception) {
			throw new AccessFailedException ("Database Access Failed");
		}
		return student;
	}

	/**
	 * Delete student records.
	 * 
	 * @param Rollnumber
	 */
	public boolean deleteStudentDetails(String rollNumber) {
		final String deleteQuery = "DELETE from student_records where rollnumber =?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(deleteQuery);) {
			preparestatement.setString(1, rollNumber );

			return preparestatement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new AccessFailedException ("Database Access Denied");
		}
	}

	/**
	 * Update student details.
	 * 
	 * @param Student student
	 */
	public boolean updateStudentDetails(Student student) {
		final String updateQuery = "UPDATE student_records SET name=?, departmentname=?, email=?, gender=?, dateofbirth=?, address=? where rollnumber=? ";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(updateQuery);) {

			preparestatement.setString(1, student.getName());
			preparestatement.setString(2, student.getDepartmentName());
			preparestatement.setString(3, student.getEmail());
			preparestatement.setString(4, student.getGender());
			preparestatement.setDate(5, student.getDateOfBirth());
			preparestatement.setString(6, student.getAddress());
			preparestatement.setString(7, student.getRollNumber());

			return preparestatement.executeUpdate() > 0;
		} catch (SQLException exception) {
			throw new AccessFailedException ("Database Access Denied");
		}
	}

	/**
	 * List to add all admin emails.
	 */
	public List<String> selectAdminEmail() {
		final List<String> adminEmailList = new ArrayList<String>();
		final String showAllRecord = "select * from admin_records";

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(showAllRecord);) {

			while (resultset.next()) {
				String emails = resultset.getString(2);
				adminEmailList.add(emails);
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return adminEmailList;
	}
	
	
	public Map<String, Student> getAllStudents() {
		final String getstudent = "Select * From student_records";
		final Map<String, Student> studentList = new HashMap<String, Student>();

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(getstudent);
				ResultSet resultset = statement.executeQuery();) {

			while (resultset.next()) {
				Student student = new Student(resultset.getString("rollnumber"), resultset.getString("name"),
						resultset.getString("departmentname"), resultset.getString("email"),
						resultset.getString("gender"), resultset.getDate("dateofbirth"),
						resultset.getString("address"));

				studentList.put(student.getRollNumber(), student);
			}
		} catch (SQLException e) {
			throw new AccessFailedException("Database Access Failed");
		}
		return studentList;
	}
}
