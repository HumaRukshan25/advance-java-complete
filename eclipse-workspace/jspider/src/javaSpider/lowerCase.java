package javaSpider;

public class lowerCase {
	static void reverse(String s) {
		String temp="";
		for(int i=s.length()-1;i>=0;i--) {
		if(s.charAt(0)!=' ') {
				temp+=s.charAt(i);
			}
		}
		System.out.println(temp);
	}
	public static void main(String[] args) {
	String s=" My first reverse each word program in java";
	reverse(s.trim());
	}
}
