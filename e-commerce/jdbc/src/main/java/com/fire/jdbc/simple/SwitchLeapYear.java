package com.fire.jdbc.simple;

import java.util.Scanner;

public class SwitchLeapYear {

	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter Year :");
//		int year = scanner.nextInt();
//		
//		System.out.println("Enter month :");
		A a1 = new A();
		a1.i = 10;
		a1.m1();
		//A a2 = a1;
		//a2.m1();
		a1 = new A();
		a1.m1();

		
	}

}

class A{
	int i;
	
	void m1() {
		System.out.println(i);
	}
}
