package com.basics.collection;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;

public class LearningList {

	public static void main(String[] args) {
		try {
			System.out.println("Outer try block");//1
			try {
				System.out.println("Inside try block");//2
				System.out.println(10/0);
			} catch (ArithmeticException e) {
				System.out.println("Inside catch block");//3
			}
			System.out.println("Inside of outer try block");//4
		} catch (Exception e) {
			System.out.println("Outer catch block");
		}
		finally {
			System.out.println("Outer finally block");//5 
		}
//		try {
//			System.out.println("Hello");
//			System.out.println(10 / 0);
//			System.out.println("Hiii");
//		} catch (Exception e) {
//			System.out.println(10 / 0);
//		} finally {
//			System.out.println("Fire");
//		}
//		System.out.println("Bye");
//		try {
//			System.out.println(10/0);
////			PrintWriter pw = new PrintWriter("abc.txt");
//		}
//		catch (ArithmeticException e) {
//			System.out.println("ArithmeticException"); 
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	}

//	Case:-1 If  there is no Exception --> 1,2,3,5 Normal Termination
//	Case:-2 If an Exception rised at stmt-2 and corresponding catch block matched --> 1,4,5 Normal Termination
//	Case:-3 If an Exception raised in stmt-2 and corresponding catch block is not matched --> 1, Abnormal Termination
//	Case:-4 If an exception raised in stmt-4 and stmt-5 --> Abnormal Termination

}
