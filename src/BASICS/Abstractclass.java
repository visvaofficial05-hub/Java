package BASICS;
abstract class element
{int a=10;
abstract void meth();
abstract void meth2();
void me() {
	System.out.println("normal");
}
}
abstract class Animal{
	abstract void sound();
	//abstract method
	void eat() {
		System.out.println("this animal eats food");
	}
}
class Dog extends Animal{
	void sound() {
		System.out.println("dog bark");
	}
}
public class Abstractclass{
public static void main(String[]args)
{
	Animal a=new Dog();
	a.sound();
	a.eat();
}

}
