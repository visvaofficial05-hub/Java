package BASICS;
interface Vehicle{
	void start();
	abstract void new1();
	default void normal() {
		System.out.println("Default");
	}
static void n3() {
	System.out.println("static method");
}
}
class Car implements Vehicle{
	public void start() {
		System.out.println("car is starting");
	}
	public void new1() {
	}
}
public class Introinterface {
	public static void main(String[]args) {
		Vehicle v=new Car();
		v.normal();
		Car C=new Car();
		C.start();
		v.normal();
	}
}
