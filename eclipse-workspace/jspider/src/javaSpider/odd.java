package javaSpider;

public class odd {

		static void arr(int a[],int index) {
			if(index<0) {
				return;
			}
			if(a[index]%2!=0)
			System.out.println(a[index]);
			arr(a,index-1);
		}
		public static void main(String[] args) {
			int a[]= {1,4,5,6};
			arr(a,a.length-1);
	}
	}

