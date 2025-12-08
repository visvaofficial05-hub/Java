package BASICS;

import java.util.Scanner;
public class Vccheck {
	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Enter a character: ");
		        char ch = sc.next().toLowerCase().charAt(0);
		        if (ch=='a' || ch=='b' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
		            System.out.println(ch + " is a Vowel.");
		        } else {
		            System.out.println(ch + " is a Consonant.");
		        }
		        sc.close();
		    }
	}