/***********************************************************
 * Copyright 2022 @author Anshuman Biswal  All rights reserved.
 *
 ***********************************************************/

package com.anshuman.itadmin.service;

import com.anshuman.itadmin.model.Admin;
import com.anshuman.itadmin.model.Department;
import com.anshuman.itadmin.model.DepartmentEnum;
import com.anshuman.itadmin.model.HR;
import com.anshuman.itadmin.model.Legal;
import com.anshuman.itadmin.model.Technical;

/**
 * Factory class that returns the Department object based on the int value
 * @author Anshuman Biswal
 *
 */
public class DepartmentFactory {
	
	/**
	 * Get the department based on the numeric value
	 * @param value
	 * @return
	 */
	public static Department getDepartment(int value) {
		
		DepartmentEnum dp = DepartmentEnum.fromValue(value);
		switch(dp) {
		case Admin:
			return new Admin();
		case HR:
			return new HR();
		case Legal:
			return new Legal();
		case Technical:
			default:
			return new Technical();
		}
		
	}

}
