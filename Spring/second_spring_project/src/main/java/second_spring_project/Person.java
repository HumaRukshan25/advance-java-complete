package second_spring_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component // to make class as bean class or component class
public class Person {
//	Car c;
	@Autowired
	@Qualifier(value="bike")
    Vehicle v;
	public Person() {
		System.err.println("Person Class Constructor");
	}
	
//	void drive() {
//	c.start();
//	c.stop();
//	}

}




