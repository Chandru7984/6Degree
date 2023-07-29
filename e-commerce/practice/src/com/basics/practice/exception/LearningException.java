package com.basics.practice.exception;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LearningException {

//	public static void main(String[] args) {
//		
//		dostuff();
//	}
//
//	private static void dostuff() {
//		domoreStuff();
//		System.out.println(10/0);
//		
//	}
//	
//	private static void domoreStuff() {
////		System.out.println(10/0);
//		System.out.println("Hello Java");
//	}

//	public static void main(String[] args) throws InterruptedException {
//		
////		PrintWriter pw =  new PrintWriter("abc.txt");
////		pw.println("Hello java");
//		System.out.println("I want to sleep happily");
//		Thread.sleep(1000);
//		
//	}
	
	// Method calling itself is called Recursion Or
	// Method calling them self 
	public void methodA() {

		methodA();
	}

	public void methodA1() {
		System.out.println("Hello");
	}
	
	public static void main(String[] args) {
		LearningException exceptions = new LearningException();
		ArrayList<String> a =new ArrayList<>();
		a.add("Chandan");
		a.add("rohan");
		a.add("deva");
		a.add("Chandru");
		a.add("Chandan");
		a.add("Chandru");
		Set<String> methodB = exceptions.methodB(a);
		
		for (String string : methodB) {
		System.out.println(string);	
		}
		
	
	}

	public <T>Set<T> methodB(List<T> t) {
		HashSet<T> hashSet = new HashSet<>(t);//remove all duplicate
		ArrayList<T> arrayList = new ArrayList<>(hashSet); //
		return hashSet;
		
	}
	
	
}
