package BASICS;
import java.util.Scanner;
public class Atm {
	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        double balance = 500000;       
		        double min_balance = 100000;   
		        System.out.print("Enter withdrawal amount: ");
		        double withdraw_amount = sc.nextDouble();
		        if (withdraw_amount <= 0) {
		            System.out.println("Invalid withdrawal amount!");
		        }else if (balance - withdraw_amount < min_balance) {
		            System.out.println("Withdrawal Cancelled! Minimum balance should maintained.");
		        }else {
		            balance -= withdraw_amount;
		            System.out.println("Withdrawal successful!");
		            System.out.println("Updated balance: " + balance);
		        }sc.close();
		    }
		}