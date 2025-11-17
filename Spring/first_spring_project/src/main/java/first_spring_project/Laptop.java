package first_spring_project;

import lombok.NoArgsConstructor;


public class Laptop implements Computer{
	
	
	public Laptop() {
		System.out.println("in laptop constructor");
	}

	public void compile() {
		System.out.println("code compiled in laptop");
	}

}
