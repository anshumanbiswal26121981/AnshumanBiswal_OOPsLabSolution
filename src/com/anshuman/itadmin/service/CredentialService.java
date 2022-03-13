/***********************************************************
 * Copyright 2022 @author Anshuman Biswal  All rights reserved.
 *
 ***********************************************************/

package com.anshuman.itadmin.service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.anshuman.itadmin.model.Employee;

/**
 * Credential service is the service class which shall be able to 
 * generate password and  show the credentials of an Employee
 * @author Anshuman Biswal
 *
 */
public class CredentialService {
	
	private Employee emp;
	public CredentialService(Employee emp) {
		this.emp = emp;
	}
	
	/**
	 * Generate password of length. the password is the mix of numeric,upppercase, lowercase and special character
	 * @param length
	 * @return
	 */
	public final String generatePassword(int length) {
		if (length < 8) {
			throw new IllegalArgumentException("Password cannot be less than 8 characters length");
		}
		StringBuilder sb = new StringBuilder();
	    SecureRandom rnd = new SecureRandom();
	    String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
	    String numericChars = "0123456789";
	    String specialChars = "~`!@#$%^&*()-_=+[{]}\\\\|;:\\'\\\",<.>/?";
	    String PASSWORD_ALLOW = lowercaseChars + uppercaseChars + numericChars + specialChars;

	    StringBuilder result = new StringBuilder(length);

        // at least 2 chars (lowercase)
        String strLowerCase = generateRandomString(lowercaseChars, 2, rnd);
        result.append(strLowerCase);

        // at least 2 chars (uppercase)
        String strUppercaseCase = generateRandomString(uppercaseChars, 2, rnd);
        result.append(strUppercaseCase);

        // at least 2 digits
        String strDigit = generateRandomString(numericChars, 2, rnd);
        result.append(strDigit);

        // at least 2 special characters (punctuation + symbols)
        String strSpecialChar = generateRandomString(specialChars, 2, rnd);
        result.append(strSpecialChar);

        // remaining, just random
        String strOther = generateRandomString(PASSWORD_ALLOW, length - 8, rnd);
        result.append(strOther);

        String password = result.toString();
        shuffleString(password);

        return password;
	}
	
	 private static String generateRandomString(String input, int size, SecureRandom random) {

	        if (input == null || input.length() <= 0)
	            throw new IllegalArgumentException("Invalid input.");
	        if (size < 1) throw new IllegalArgumentException("Invalid size.");

	        StringBuilder result = new StringBuilder(size);
	        for (int i = 0; i < size; i++) {
	            // produce a random order
	            int index = random.nextInt(input.length());
	            result.append(input.charAt(index));
	        }
	        return result.toString();
	    }

	    // for final password, make it more random
	    public static String shuffleString(String input) {
	        List<String> result = Arrays.asList(input.split(""));
	        Collections.shuffle(result);
	        // java 8
	        return result.stream().collect(Collectors.joining());
	    }
	    
	/**
	 * Prints the employee details
	 */
	public void showCredentials() {
		System.out.println("====== Frist Name: "+ emp.getFirstName()+"======");
		System.out.println("====== Last Name: "+ emp.getLastName()+"======");
		System.out.println("====== Email: "+ emp.getEmail()+"======");
		System.out.println("====== Password: "+ emp.getPassword()+"======");
	}

}
