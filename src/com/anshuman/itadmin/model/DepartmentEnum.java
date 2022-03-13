/***********************************************************
 * Copyright 2022 @author Anshuman Biswal  All rights reserved.
 *
 ***********************************************************/

package com.anshuman.itadmin.model;

import java.util.Arrays;

public enum DepartmentEnum {
	Technical(1),
	Admin(2),
	HR(3),
	Legal(4);

	private int value;
	
	DepartmentEnum(int val) {
		this.value = val;
	}
	
	public static DepartmentEnum fromValue(int value) {
		for (DepartmentEnum departmentEnum : values()) {
			if (departmentEnum.value == value) {
				return departmentEnum;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}

}
