package org.jsp.springbootdemo;



import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	
	private int id;
	private String name;
	private int cc;
	private int noOfCylinders;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getNoOfCylinders() {
		return noOfCylinders;
	}
	public void setNoOfCylinders(int noOfCylinders) {
		this.noOfCylinders = noOfCylinders;
	}
	
	
	public Engine(int id, String name, int cc, int noOfCylinders) {
		super();
		this.id = id;
		this.name = name;
		this.cc = cc;
		this.noOfCylinders = noOfCylinders;
	}
	public Engine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
