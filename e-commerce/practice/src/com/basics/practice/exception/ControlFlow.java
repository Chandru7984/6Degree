package com.basics.practice.exception;

public class ControlFlow{

	public static void main(String[] args) {
		
		try {
			System.out.println(10/0);
			String s = null;
			System.out.println(s);
			
		} catch (ArithmeticException | NullPointerException e) {
			e.printStackTrace();
		}
		
		
	}

//		try {
//			System.out.println("Statement-1");
//			System.out.println("Statement-2");
//			System.out.println("Statement-3");
//			try {
//				System.out.println(10/0);
//				System.out.println("Statement-4");
//				System.out.println("Statement-5");
//				System.out.println("Statement-6");
//			} catch (Exception e) {
//				System.out.println("Statement-7");
//			} finally {
//				System.out.println("Statement-8");
//			}
//			System.out.println("Statement-9");
//		} catch (Exception e) {
//			System.out.println("Statement-10");
//		} finally {
//			System.out.println("Statement-11");
//		}
//		System.out.println("Statement-12");
//	}
//
}
//1. If there is no Exception --> 1,2,3,4,5,6,8,9,11,12 Normal Termination
//2. If Exception raised at stmt-2 and corresponding catch block matched --> 1,10,11,12 Normal Termination
//3. If Exception raised at stmt-2 and corresponding catch block not matched --> 1,10,11,12 Normal Termination


// Control Flow inside try-catch
// Control Flow in try-catch-finally
// nested try catch finally
// Control Flow in nested try-catch-finally
