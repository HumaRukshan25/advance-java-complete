package javaSpider;

public class PrimeArr {
	
	public static boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	public static void printPrime(int a[]) {
		for(int i:a) {	
			if(isPrime(i))
				System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int a[]= {2,4,3,9,34,8,7,88};
		printPrime(a);
	}
}
