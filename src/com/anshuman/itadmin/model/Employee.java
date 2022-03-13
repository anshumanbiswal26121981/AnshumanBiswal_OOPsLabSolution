/***********************************************************
 * Copyright 2022 @author Anshuman Biswal  All rights reserved.
 *
 ***********************************************************/

package com.anshuman.itadmin.model;

import com.anshuman.itadmin.service.DepartmentFactory;

/**
 * Employee class that will hold the employee details
 * @author Anshuman Biswal
 *
 */
public class Employee {
	
	private String firstName, lastName, password;
	private Department department;
	
	public Employee(String firstName, String lastName, int department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = getDepartment(department);
	}

	/**
	 * Return the last name of the employee
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Return the first name of the employee
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * returns the email of the employee
	 * @return
	 */
	public String getEmail() {
		return department.getEmail(this.firstName, this.lastName);
	}


	/**
	 * Returns the password set for the empoyee
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the employee
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * returns the department of the employee
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	
	private Department getDepartment(int department2) {
		// TODO Auto-generated method stub
		return DepartmentFactory.getDepartment(department2);
	}
}
