package com.bookservice.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderDemo {

	PasswordEncoder encoder = new BCryptPasswordEncoder();
	

	String getEncodedString(String password) {
		String encodedString = encoder.encode(password);
		return encodedString;
	}
	
}
