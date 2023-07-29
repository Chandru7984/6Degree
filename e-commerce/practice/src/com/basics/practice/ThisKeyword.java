package com.basics.practice;

//public class ThisKeyword {
//	
//	int id;
//	String name;
//	String place;
//	static String company = "6Degree";
//
//	static void change() {
//		company = "Honeycomb";
//	}
//
////	this keyword refers the current instance
////	If local and instance variables are same then we use this keyword
////	If local and instance variables are different then no need to use of this keyword
//	public ThisKeyword(int id, String name, String place) {
//		this.id = id;
//		this.name = name;
//		this.place = place;
//	}
//
//	public void printing() {
//		System.out.println(id + " " + name + " " + place);
//	}
//}
////
//class Obj {
//
//	public static void main(String[] args) {
//
//		ThisKeyword obj = new ThisKeyword(101, "Chandru", "Bengaluru");
//		ThisKeyword obj1 = new ThisKeyword(102, "Venka", "Bengaluru");
//		ThisKeyword obj2 = new ThisKeyword(103, "Chandan", "Bengaluru");
//		obj.printing();
//		obj1.printing();
//		obj2.printing();
//	}
//}
//usage of this keyword --> 1.used to refer the current class instance variable
//2. used to invoke or call the current class method
//class A {
//	void m() {
//		System.out.println("hello m");
//	}
//
//	void n() {
//		System.out.println("hello n");
//		// m();//same as this.m()
//		this.m();
//	}
//}
//
//class TestThis4 {
//	public static void main(String args[]) {
//		A a = new A();
//		a.n();
//	}
//}

//3. used to call the current class constructor.
// ----------------------------------------------------
//--> Calling default constructor from parameterized const...
//class A {
//	A() {
//		System.out.println("Hello Constructor");
//	}
//
//	A(int x) {
//		this();
//		System.out.println(x);
//	}
//}
//
//class B {
//	public static void main(String[] args) {
//
//		A a = new A(20);
//	}
//}

//--> Calling parameterized constructor from default const...
//class A {
//	A(){
//		this(20);
//		System.out.println("Hello Constructor");
//		
//	}
//	
//	A(int x){
//		System.out.println(x);
//	}
//}
//class B{
//	public static void main(String[] args) {
//		
//		A a = new A();
//	}
//}

//Used to reuse the constructor

//4. to pass an argument in the method
//------------------------------------------------------------

//class A {
//	void m(A obj) {
//		System.out.println("This can be call by n method");
//	}
//
//	void n() {
//		m(this);
//	}
//}
//
//class B {
//	public static void main(String[] args) {
//
//		A a = new A();
//		a.n();
//	}
//}

//6. Used to return current class inatance

//class A {
//	A getA() {
//		return this;
//	}
//
//	void msg() {
//		System.out.println("Hello java");
//	}
//}
//
//class b extends A{
//	public static void main(String[] args) {
//		new A().getA().msg();
//	}
//	
//	@Override
//	void msg() {
//		System.out.println("Hello");
//	}
//}
