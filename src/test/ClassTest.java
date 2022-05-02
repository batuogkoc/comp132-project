package test;

public class ClassTest {
	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		a.printA();
		b.printA();
	}
}

class A {
	int a = 3;
	void printA() {
		System.out.println("a: "+a);
	}
}

class B extends A {
	int b = 4;
	
	void modifyB() {
		b = 5;
	}
	
	void printA() {
		modifyB();
		System.out.println("a: "+(a+b));
	}
}