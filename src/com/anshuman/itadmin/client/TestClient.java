/***********************************************************
 * Copyright 2022 @author Anshuman Biswal  All rights reserved.
 *
 ***********************************************************/

package com.anshuman.itadmin.client;

import java.util.Scanner;

import com.anshuman.itadmin.model.Employee;
import com.anshuman.itadmin.service.CredentialService;

/**
 * Test client class to execute the IT admin app
 * @author Anshuman Biswal
 *
 */
public class TestClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Firstname: ");
		String fName = sc.nextLine();
		System.out.println("Enter lastName: ");
		String lname = sc.nextLine();
		System.out.println();
		System.out.println("Please enter the department from the following: ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human resource");
		System.out.println("4. Legal");
		int dpno = sc.nextInt();
		Employee emp = new Employee(fName, lname, dpno);
		CredentialService cs = new CredentialService(emp);
		String pwd = cs.generatePassword(12);
		emp.setPassword(pwd);
		cs.showCredentials();
		

	}

}
