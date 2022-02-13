package com.studentrecord.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.studentrecord.view.StudentRecordInformation;

/**
 * StudentRecordManagement. The Student Record Management in which student can
 * login to view their record which was maintained by the Management Admin that
 * they could view, delete, insert and update to maintain the student records
 * for the Management.
 * 
 * @author ThalaimalaiPandiyanT
 *
 */
public class StudentRecordMain {

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
		StudentRecordMain.selectChoice();
	}

	public static void selectChoice() {

		do {
			final Logger logger = Logger.getLogger(StudentRecordMain.class);
			logger.info("STUDENT RECORD MANAGEMENT SYSTEM\n1.Admin Login\n2.Admin Signup\n3.StudentLogin\n4.Exit");
			final int choice = Integer.parseInt(StudentRecordInformation.getChoice());

			switch (choice) {
			case 1:
				StudentRecordInformation.adminLogin();
				break;
			case 2:
				StudentRecordInformation.adminSignup();
				break;
			case 3:
				StudentRecordInformation.studentLogin();
				break;
			default:
				StudentRecordInformation.SCANNER.close();
				System.exit(0);
			}
		} while (true);
	}
}