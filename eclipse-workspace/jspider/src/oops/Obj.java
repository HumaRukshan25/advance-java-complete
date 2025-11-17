package oops;

public class Obj {
	int rollno;
	String name;
	
	//1. Obj creation
//  public static void main(String[] args) {
//   System.out.println(	new Obj());
//   Obj a=new Obj();
//   System.out.println(a.rollno +" "+a.name); //0 null
//}
	
	//2.Local var global
//	int b=20;
//	public void m1() {
//		int a=10;
//		System.out.println(a); //10
//		System.out.println(b); //20
//	}
//	public static void main(String[] args) {
//		Obj aa=new Obj();
//		aa.m1();
//	}
	
	//3. Local var & global var in static method 
//	int b=20;
//	public static void m1() {
//		int a=10;
//		System.out.println(a); //10
//		Obj aa=new Obj();
//		System.out.println(aa.b); //20
//	}
//	public static void main(String[] args) {
//		m1();
//	}
	
	//4. nonstatic method to manipulate nonstatic variables
//	public void nm(int r,String n) {
//		rollno=r;
//		name=n;
//		System.out.println(rollno);
//		System.out.println(name);
//	}
//	public static void main(String[] args) {
//		Obj o=new Obj();
//		o.nm(1,"dingu");
//		o.nm(2,"ding");	
//	}

	//5. constructor
//	Obj(){
//		System.out.println("const 1");
//	}
//	Obj(int a){
//		System.out.println("1 para const");
//	}
//	Obj(String s){
//		System.out.println("1 para const");
//	}
//	Obj(int b,int c){
//		System.out.println("2 para const");
//	}
//	public static void main(String[] args) {
//		System.out.println("hi"); ///hi
//		new Obj();  //const 1
//	 new Obj("name"); //1 para const
//	}
  
// super call	
//Obj(){
//		super( );
//		System.out.println("no para");
//	}
//	Obj(int a){
//		System.out.println("Parent");	
//	} //main Parent hii1
	
//	Obj(){
//		System.out.println("nopara");
//	}
//	Obj(String s){
//	System.out.println("String data" + s);	
//	}
	
	//static nonstatic access in child
	static int gen=23;
	static {
		System.out.println("in static init or block");
	}
	static {
		System.out.println("in static block");
	}
	public  static void m11() {
		System.out.println("in static");
	}
	public void m22() {
		System.out.println("in non static");
	}
	
	
  
}
