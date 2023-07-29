package com.fire.jdbc.simple;

public class StaticExa {
	
	static int i = 5;
	static int j;

	public static void main(String[] args) {
		
		StaticExa a1 = new StaticExa();
		a1.j = 5;
		System.out.println(a1.j);
		
		StaticExa a2 = new StaticExa();
		a2.j = 15;
		System.out.println(a2.j);
		
		System.out.println(a1.j);
		

	}

}
