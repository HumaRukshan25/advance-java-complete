package javaSpider;
import java.util.*;
public class Ewallet {
	static int balance=1500;
	public static void m1() {
		System.out.println("Welcome to shooping Dashboard");
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 for Select watches, Press 2 for Select Bag");
		int m=sc.nextInt();
		
		switch(m) {
		case 1:
			System.out.println("Select Watches");
			System.out.println("From the below Brands: Titan , Fossil, FastTrack");
			break;
		case 2:
			System.out.println("Select Bag");
			break;
		}
			
		}
		public static void m2() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the amount :");
			int add=sc.nextInt();
			balance+=add;
			System.out.println("Amount Added successfully...");
			
			
	}
		public static void Balance() {
			m2();
		System.out.println(balance);
	
			
	}
		
		
	public static void main(String[] args) {
		System.out.println("Welcome to E-Wallet application");
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 for Go to Shooping, Press 2 for Add Amount Press 3 for View balance ");
		int n=sc.nextInt();	
		
		
		switch(n) {
		case 1:
			System.out.println("Go to Shooping");
			
			m1();
			break;
		case 2:
			System.out.println("Add Amount");
			m2();
			break;
		case 3:
			System.out.println("View balance");
			Balance();
			
			break;
		}
	}
}
