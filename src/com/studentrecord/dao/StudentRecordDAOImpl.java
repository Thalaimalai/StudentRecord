package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.studentrecord.model.Admin;
import com.studentrecord.model.Student;
import com.studentrecord.service.StudentInformationService;

public class StudentRecordDAOImpl implements StudentRecordDAO {

	public void insertAdminSignup(Admin admin) {
		boolean isEmailFound = false;

		try {
			Connection connection = StudentDatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select adminemail from admin_records where adminemail='" + admin.getAdminEmail() + "'");

			while (resultset.next()) {
				isEmailFound = true;
			}
			
			if (!isEmailFound) {
			   	statement.executeUpdate("insert into admin_records(adminname,adminemail,password)values('" + admin.getAdminName() + "','" + admin.getAdminEmail() + "','" + admin.getPassword() + "') ");
				System.out.println("New Admin added successfully.");
			} else if (isEmailFound) {
				System.out.println("This mail id already exists");
			}
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}

	public void getAdminLogin(final String adminEmail, final String password) {
		boolean isEmailFound = false;
		
		try {
			Connection connection = StudentDatabaseConnection.getConnection();	
			PreparedStatement preparestatement = connection.prepareStatement("select adminemail, password from admin_records where adminemail='" + adminEmail + "' AND password='" + password + "'");
			ResultSet resultset = preparestatement.executeQuery();

			while (resultset.next()) {
				System.out.println("Login Successfully.");
				isEmailFound = true;
				StudentInformationService.getAdminWorks();

				if (!isEmailFound) {
					System.out.println("Invalid Data");
				}
			}
			resultset.close();
			preparestatement.close();
			connection.close();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}

	public void studentLogin(final String rollNumber, final String studentName) {
		boolean isStudentFound = false;
		
		try {
			Connection connection = StudentDatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select rollnumber,name from student_records where rollnumber= '" + rollNumber	+ "'AND  name= '" + studentName + "'");
			
			while (resultset.next()) {
				isStudentFound = true;
				System.out.println("Login Successful");

				PreparedStatement preparestatement = connection.prepareStatement("select * from student_records");
				resultset = preparestatement.executeQuery();
					
				while (resultset.next()) {
					System.out.println("RollNumber :" + resultset.getInt(1));
					System.out.println("Name :" + resultset.getString(2));
					System.out.println("Departmentname :" + resultset.getString(3));
					System.out.println("Email :" + resultset.getString(4));
					System.out.println("Gender :" + resultset.getString(5));
					System.out.println("DateOfBirth :" + resultset.getString(6));
					System.out.println("Address :" + resultset.getString(7));
				}
				
				if(!isStudentFound) {
					System.out.println("Invalid Student Data");
				}
			}
			resultset.close();
			statement.close();
			connection.close();	
		} catch (SQLException exception) {
			    System.out.println(exception);
		}
	}

	public void insertStudentDetails(Student student) {
		try {
			Connection connection = StudentDatabaseConnection.getConnection();
			PreparedStatement preparestatement = connection.prepareStatement("insert into student_records values(?,?,?,?,?,?,?)");
			
			preparestatement.setString(1, student.getRollNumber());
			preparestatement.setString(2, student.getName());
			preparestatement.setString(3, student.getDepartmentName());
			preparestatement.setString(4, student.getEmail());
			preparestatement.setString(5, student.getGender());
			preparestatement.setDate(6, student.getDateOfBirth());
			preparestatement.setString(7, student.getAddress());
			preparestatement.executeUpdate();
			
			preparestatement.close();
			connection.close();
			
		} catch(SQLException exception) {
			System.out.println(exception);
		}
	}

	public void viewStudentDetails(String rollNumber) {
		try {
			Connection connection = StudentDatabaseConnection.getConnection();
			PreparedStatement preparestatement = connection.prepareStatement("select * from student_records where rollnumber ='" + rollNumber +"'");
			ResultSet resultset = preparestatement.executeQuery();
			ResultSetMetaData metadata = resultset.getMetaData();
			int columnsNumber = metadata.getColumnCount();
			
			while(resultset.next()) {
				 for(int i = 1; i <= columnsNumber; i++)
				        System.out.print(resultset.getString(i) + " ");
				    System.out.println();
			}
			resultset.close();
			preparestatement.close();
			connection.close();
            
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}

	public void deleteStudentDetails(String rollNumber) {
		try {
			Connection connection = StudentDatabaseConnection.getConnection();
			PreparedStatement preparestatement = connection.prepareStatement("DELETE from student_records where rollnumber ='" + rollNumber +"';");
			preparestatement.executeUpdate();		
			
			preparestatement.close();
			connection.close();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}
}