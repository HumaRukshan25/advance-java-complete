package second_spring_project;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Primary
@Component
public class Bike implements Vehicle{
	
	private int id;
	private String brand;
	private double price;
	private String color;
	public Bike() {
	System.out.println("Bike class constructor");
	}

	public void start() {
		System.out.println("bike started");
	}
	
	public void stop() {
		System.out.println("bike stopped");
		
	}
	

}

