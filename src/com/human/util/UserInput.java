package com.human.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
	private static Scanner scanner = new Scanner(System.in);
	public static int inputInt(String st) {
		try {
			System.out.println(st + "정수 입력>>");
		} catch(InputMismatchException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static String inputString(String st) {
		try {
			System.out.println(st + "문자 입력>>");
		} catch(InputMismatchException e) {
			e.printStackTrace();
		}
		return scanner.nextLine();
	}
}
