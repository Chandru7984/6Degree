package com.fire.jdbc.simple;

public class Example2 {

	public static void main(String[] args) {

		B b = new B();
		b.m1();
		System.out.println("Hiiii");
	}

	static {
		System.out.println("hlo");
	}
	static {
		System.out.println("bhfeb");
	}
}
class B{
	void m1() {
		System.out.println("A class");
	}
	static {
		System.out.println("static A");
	}
	{
		System.out.println("non static A");
	}
}