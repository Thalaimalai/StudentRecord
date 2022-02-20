package com.studentrecord.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.studentrecord.view.StudentView;

/**
 * StudentRecordManagement. The Student Record Management in which student can
 * login to view their record which was maintained by the Management Admin that
 * they could view, delete, insert and update to maintain the student records
 * for the Management.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentManagement {
	
	/**
	 * Illustrates the login and signup for users.
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		final Properties properties = new Properties();
		properties.load(new FileInputStream("log4j.properties"));
		PropertyConfigurator.configure(properties);
		StudentManagement.selectChoice();
	}

	/**
	 * Select choice to login and signup.
	 */
	public static void selectChoice() {

		do {
			final Logger LOGGER = Logger.getLogger(StudentManagement.class);
			LOGGER.info("STUDENT RECORD MANAGEMENT SYSTEM\n1.Admin Login\n2.Admin Signup\n3.StudentLogin\n4.Exit");
			final int choice = Integer.parseInt(StudentView.getChoice());

			switch (choice) {
			case 1:
				StudentView.adminLogin();
				break;
			case 2:
				StudentView.adminSignup();
				break;
			case 3:
				StudentView.studentLogin();
				break;
			default:
				StudentView.SCANNER.close();
				System.exit(0);
			}
		} while (true);
	}
}