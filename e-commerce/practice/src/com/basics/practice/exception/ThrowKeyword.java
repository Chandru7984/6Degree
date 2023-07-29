package com.basics.practice.exception;

import java.io.BufferedReader;
import java.io.FileReader;

//public class ThrowKeyword {
//	
//	static ArithmeticException ae= new ArithmeticException();
//	
//	public static void main(String[] args) {
//		
//		throw ae;
//		
//	}
//
//}

class Test{
	
//	static ArithmeticException ae;
	
	
	
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("input.txt"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		throw new ArithmeticException("/by zero");
		
		// throw ae;
	}
}
