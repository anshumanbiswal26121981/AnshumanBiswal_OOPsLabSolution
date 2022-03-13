/***********************************************************
 * Copyright 2022 @author Anshuman Biswal  All rights reserved.
 *
 ***********************************************************/

package com.anshuman.itadmin.model;

import com.anshuman.itadmin.EmailFormat;

/**
 * department interface for all the department types to implement to have the email generator
 * @author Anshuman Biswal
 *
 */
public interface Department extends EmailFormat{
	
	/**
	 * Get the department name
	 * @return
	 */
	public String getDepartmentName();
	
	/**
	 * Get the email using the below arguments
	 * @param firstName
	 * @param lastName
	 * @return email string
	 */

	default String getEmail(String firstName, String lastName) {
		return String.format(EMAIL_FORMAT, firstName, lastName, getDepartmentName());
	}

}
