package oops;

import java.util.ArrayList;

public class Studmain {
public static void main(String[] args) {
	ArrayList <Stud> a= new ArrayList();
	a.add(new Stud("san",132));
	a.add(new Stud("man",12));
	Stud b=new Stud("sain",32);
	int count=0;
	if(a.contains(b)) {
		count++;
	}
	System.out.println(count);
}
}
