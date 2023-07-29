package com.basics.practice.exception;

public class DefaultExceptionHandler{

	public static void main(String[] args) {
		
		doStuff();

	}
	
	public static void doStuff() {
		doMoreStuff();
	}

	public static void doMoreStuff() {
		
		System.out.println(10/0);
	}
}
// Exception Heirarchy
//Throwable --> Exception and Error
//Exceptions --> Checked --> Compile time Exception  --> IOException, SQLException, ClassNotFoundException, FileNotFoundException
//Unchecked --> Runtime Exception --> Arithmetic Exception, NPE, NumberFormatException, ClassCastException, IOBE,AIOBE,SIOBE
//Error --> StackOverFlow, VMError, OutOfMemoryError 

//class Test{
//	public static void main(String[] args) {
//		PrintWriter pw = new PrintWriter("abc.txt");
//	}
//}

class Test1{
	public static void main(String[] args) {
		System.out.println(10/0);
	}
}

