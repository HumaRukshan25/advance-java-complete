package oops;

public class Stud {
String name;
int roll;
Stud(String name,int roll){
	this.name=name;
	this.roll=roll;
}
public boolean equals(Object o) {
	Stud s=(Stud) o;
	if(this.roll==s.roll) {
		return true;
	}
	return false;
}
}
