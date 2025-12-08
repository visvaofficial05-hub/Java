package BASICS;
import java.util.Scanner;
public class Operator {
public static void main(String[]args)
{
	int x,y,z;
	Scanner scan=new Scanner(System.in);
	System.out.println(" Enter any two numbers:");
	x=scan.nextInt();
	y=scan.nextInt();
	
	//Arthimatic
	System.out.println("ARTHIMATIC OPERATOR");
	
	z=x+y;
	System.out.println("add of two values ="+z);
	z=x-y;
	System.out.println("sub of two values="+z);
	z=x*y;
	System.out.println("mul of two values="+z);
	z=x/y;
	System.out.println("div of two values="+z);
	System.out.println("");
	
	//assign 
	System.out.println("ASSIGNMENT OPERATOR");
	
	z=x;
	System.out.println("equal="+z);
	z+=x;
	System.out.println("plus equal="+z);
	z-=x;
	System.out.println("sub equal="+z);
	z*=x;
	System.out.println("mul equal="+z);
	z/=x;
	System.out.println("div equal="+z);
	System.out.println("");
	
	//RELATIONAL
	System.out.println("RELATIONAL OPERATOR");
	
	
	System.out.println("z == x : " + (z == x));
	System.out.println("x != y : " + (x != y));
	System.out.println("x > y  : " + (x > y));
	System.out.println("x < y  : " + (x < y));
	System.out.println("x >= y : " + (x >= y));
	System.out.println("x <= y : " + (x <= y));
	System.out.println("");
	
	//logical
	System.out.println("LOGICAL OPERATORS");

	System.out.println("(x < y) && (y < z) = " + ((x < y) && (y < z)));
	System.out.println("(x > y) && (y < z) = " + ((x > y) && (y < z)));

	// l-OR 
	System.out.println("(x < y) || (y > z) = " + ((x < y) || (y > z)));
	System.out.println("(x > y) || (y > z) = " + ((x > y) || (y > z)));


	// l-NOT 
	System.out.println("!(x < y) = " + (!(x < y)));
	System.out.println("!(x > y) = " + (!(x > y)));
	System.out.println("");
	
	
	//unary operator 
	System.out.println("UNARY OPERATORS");
	
	// Post-increment
	System.out.println("x++ : " + (x++));  

	// Pre-increment
	System.out.println("++x : " + (++x));  

	// Post-decrement
	System.out.println("y-- : " + (y--));  

	// Pre-decrement
	System.out.println("--y : " + (--y));  

	// Unary plus
	System.out.println("+x  : " + (+x));  

	// Unary minus
	System.out.println("-x  : " + (-x));  
	
	//logical not
    System.out.println("!(x < y) = " + (!(x < y)));
	System.out.println("!(x > y) = " + (!(x > y)));  
}
}
