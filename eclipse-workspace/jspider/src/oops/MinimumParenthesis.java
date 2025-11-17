package oops;

import java.util.Scanner;

public class MinimumParenthesis {

	//find  miniumum number of parenthesis to make  the string valid
	//need to be removed to make the resulting string valid
	// string is considered valid if it starts with ( and ends  with )
	// open parenthesis shld apper before close

//()())() by removing ) we can make valid      ex2: (a)())()  valid  //)( invalid
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
	char[] a= s.toCharArray();
	
		
	for(int i=0;i<a.length;i++) {
					if(a[i]>='a'||a[i]>='A'||a[i]=='('||a[i]>='0') {
				for(int j=1;j<a.length;j++) {
				if(a[j]>='a'||a[j]>='A'||a[j]==')'||a[j]>='0') {
				System.out.println("it is valid");	
				
			}
				else {
					System.out.println("invalid");
				}
				
			
				
			}
				
	
	}
			
			
			
	}
	}
	}