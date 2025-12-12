package BASICS;
class Person{
	String name ="John";
	int age=30;
	void showPersonDetails(){
		System.out.println("Name"+ name);
		System.out.println("age"+age);
	}
}
class Employee extends Person{
	String jobtitle="Software Developer";
	void showEmployeeDetails() {
		System.out.println("name:"+name);
		System.out.println("age"+age);
		System.out.println("job title"+jobtitle);
	}
}
public class Task1 {
	public static void main (String[]args) {
		Employee emp=new Employee();
		System.out.println("Prop from super class");
		emp.showPersonDetails();
		System.out.println("Prop from subclass");
		emp.showEmployeeDetails();
	}

}
