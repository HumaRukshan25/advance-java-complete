package second_spring_project;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public class Car implements Vehicle {
	 private String brand;
	private double price;
	private String color;
	
	public Car() {
		System.out.println("Car class constructor");
	}
	public void start() {
		System.out.println("car started");
	}
	
	public void stop() {
		System.out.println("car stopped");
		
	}
	
	

}
