package com.incubyte.gmail.configure;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class DataGenerator {

	public static int generateRandonIntTwoDigit() {

		return RandomUtils.nextInt(9, 99);
	}

	public static String generateAlphaNumericStringBetween(int start, int end) {

		return RandomStringUtils.randomAlphanumeric(start, end);
	}

	public static String generateAlphaNumericString(int digit) {

		return RandomStringUtils.randomAlphanumeric(digit);
	}

	public static String generateAplhaString(int digit) {

		return RandomStringUtils.randomAlphabetic(digit);
	}

	public static String generateAplhaStringBetween(int start, int end) {

		return RandomStringUtils.randomAlphabetic(start, end);
	}

	public static int generateRandomIntOneDigit() {

		return RandomUtils.nextInt(2, 9);
	}
	
	public static int generateRandonInThreeDigit() {

		return RandomUtils.nextInt(99, 999);
	}
	
	public static int generateRandomIntBetweenDigit(int start, int end){
		
		return RandomUtils.nextInt(start, end);
	}
	
	public static String generateMatchItemData(int no){
		
		return RandomStringUtils.randomAlphabetic(no).toUpperCase();
	}
	}
