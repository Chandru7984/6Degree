package com.fire.jdbc.simple;

public class UnaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 5;
//		System.out.println(a++);
//		System.out.println(a++);
//		System.out.println(a);
//		
//		System.out.println(a++);
//		System.out.println(++a);
		if (a % 2 == 0) {
			++a;
		}
		++a;
		++a;
		System.out.println(a);
	}

}
