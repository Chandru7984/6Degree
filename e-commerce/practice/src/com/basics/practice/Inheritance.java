package com.basics.practice;

//public class Inheritance {
//	
//	String name = "Chandru";
//	double value = 2000f;
//}
//
//class Sample extends Inheritance{
//	
//	String friend = "Praj";
//	
//	public static void main(String[] args) {
//		
//		Sample sample = new Sample();
//		
//		System.out.println(sample.name+" "+sample.friend+" "+sample.value);
//	}
//}

//Types of Inheritance 
//1. Single level --> Class inherits another class

//class Animal{
//	void eat() {
//		System.out.println("eating");
//	}
//}
//
//class Dog extends Animal{
//	void bark() {
//		System.out.println("Barking");
//	}
//}
//
//class Finishing{
//	public static void main(String[] args) {
//		
//		Dog dog = new Dog();
//		
//		dog.eat();
//		dog.bark();
//	}
//}

//2. Multi level --> Chain of Inheritance
//class Animal{
//	void eat() {
//		System.out.println("eating");
//	}
//}
//class Dog extends Animal{
//	void bark() {
//		System.out.println("Barking");
//	}
//}
//class BabyDog extends Dog{
//	void sleep() {
//		System.out.println("Sleeping");
//	}
//}
//class Finish{
//	public static void main(String[] args) {
//		
//		BabyDog babyDog = new BabyDog();
//		
//		babyDog.eat();
//		babyDog.bark();
//		babyDog.sleep();
//	}
//}

//3. Hierarchical Inheritance --> Two or more class inherits a single class

//class Animal{
//	void eat() {
//		System.out.println("eating");
//	}
//}
//class Dog extends Animal{
//	void bark() {
//		System.out.println("Barking");
//	}
//}
//class Cat extends Animal{
//	void sleep() {
//		System.out.println("Meowing");
//	}
//}
//class Finish{
//	public static void main(String[] args) {
//		
//		Cat cat = new Cat();
//		
//		cat.eat();
//		cat.sleep();
//	}
//}

//4. Multiple Inheritance --> single class extends 2 parent class 
//
//Multiple Inheritance is not possible in java, because there is ambiguity problem.
//It is not possible to subclass extends 2 parent class. It gives compile time error.
//It is possible using Interface...
class RefA{
	
}
class RefB extends RefA{
	
}


