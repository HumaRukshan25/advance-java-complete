package first_spring_project;

import lombok.NoArgsConstructor;

public class Desktop implements Computer{
	

	
	public Desktop() {
		System.out.println("in desktop constructor");
	}

	public void compile() {
		System.out.println(" compiled the code in desktop");
		
	}

}
