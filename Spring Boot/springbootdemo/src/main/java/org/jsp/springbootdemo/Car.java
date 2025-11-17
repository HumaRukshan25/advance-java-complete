package org.jsp.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Value("101")
	private int id;
	@Value("BMW")
	private String brand;
	@Value("100000000")
	private double price;
	@Value("Black")
	private String color;
	
	@Autowired
	private Engine e;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Engine getE() {
		return e;
	}
	public void setE(Engine e) {
		this.e = e;
	}
	
	public Car(int id, String brand, double price, String color, Engine e) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.color = color;
		this.e = e;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
