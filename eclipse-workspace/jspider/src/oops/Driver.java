package oops;

public class Driver {
public static void main(String[] args) {
	 CarPar p=new MiniChild();
MiniChild m =(MiniChild)p;
m.m1();
m.m2();
	p.m1();//childs m1()
	p.m2();
	
	CarPar.methodd(20);

}
}
