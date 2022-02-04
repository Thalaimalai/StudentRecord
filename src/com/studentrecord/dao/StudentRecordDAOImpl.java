package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.studentrecord.model.Student;

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
	public void insertAdminSignup(final String adminName, final String adminEmail, final String password) {
		final String insertQuery = "insert into admin_records values(?,?,?)";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setString(1, adminName);
			statement.setString(2, adminEmail);
			statement.setString(3, password);

			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Details Not Inserted");
		}
	}

	/**
	 * Student login to view the respective details.
	 * 
	 * @param Rollnumber
	 * @param Student    name
	 */
	public void studentLogin(final String rollNumber, final String studentName) {
		boolean isRecordFound = false;
		final String studentLogin = "select * from student_records where rollnumber= '" + rollNumber + "'AND  name= '"
				+ studentName + "'";

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(studentLogin);) {

			while (resultset.next()) {
				isRecordFound = true;
				System.out.println("Login Successful");
				System.out.println(String.format("%s %s %s %s %s %s %s", resultset.getString(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getString(6),
						resultset.getString(7)));
			}

			if (!isRecordFound) {
				System.out.println("Invalid Student Data");
			}
		} catch (SQLException exception) {
			System.out.println("Record Not Found");
		}
	}

	/**
	 * Insert student details.
	 * 
	 * @param Student student
	 */
	public void insertStudentDetails(final Student student) {
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

			preparestatement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Student Record Not Inserted");
		}
	}

	/**
	 * View student records.
	 * 
	 * @param Rollnumber
	 */
	public void viewStudentDetails(final String rollNumber) {
		final String viewQuery = "select * from student_records where rollnumber ='" + rollNumber + "'";

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultset = statement.executeQuery(viewQuery);) {

			while (resultset.next()) {
				System.out.println(String.format("%s %s %s %s %s %s %s", resultset.getString(1), resultset.getString(2),
						resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getString(6),
						resultset.getString(7)));
			}
		} catch (SQLException exception) {
			System.out.println("Error-Details Not Shown");
		}
	}

	/**
	 * Delete student records.
	 * 
	 * @param Rollnumber
	 */
	public void deleteStudentDetails(String rollNumber) {
		final String deleteQuery = "DELETE from student_records where rollnumber =?";

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparestatement = connection.prepareStatement(deleteQuery);) {

			preparestatement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Record Not Deleted");
		}
	}

	/**
	 * Update student details.
	 * 
	 * @param Student student
	 */
	public void updateStudentDetails(Student student) {
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

			preparestatement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Record Not Updated");
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
}
