package first_spring_project;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter


public class Company {
	int pinCode;
	String name;
	
	Developer dev; //if it is nothing nullpointer exception
//	Developer dev=new Developer();//later
	Laptop lap;
	Desktop desk;
	
	
	@Override
	public String toString() {
		return "Company [pinCode=" + pinCode + ", name=" + name + ", devNames=" + devNames + "]";
	}

	public Company() {
	System.out.println("in company constructor");
	}

	List<String> devNames;
	Map<String,Integer> deptAndDev; 
	
	

//	//to get object instead of address
//
//	@Override
//	public String toString() {
//		return "Company [pinCode=" + pinCode + ", name=" + name + ", dev=" + dev + ", lap=" + lap + ", desk=" + desk
//				+ "]";
//	}
//	//setter injection for setName
//	public void setName(String name) {
//	this.name = name;
//}
//	public void setPinCode(int pinCode) {
//		this.pinCode = pinCode;
//	}
//
//
//public void setDev(Developer dev) {
//	this.dev = dev;
//}
//
//public void setLap(Laptop lap) {
//	this.lap = lap;
//}
//
//public void setDesk(Desktop desk) {
//	this.desk = desk;
//}
//
//
//public Company(int pinCode, String name, Developer dev, Laptop lap, Desktop desk) {
//	super();
//	this.pinCode = pinCode;
//	this.name = name;
//	this.dev = dev;
//	this.lap = lap;
//	this.desk = desk;
//}
//
//	
//	public static void main(String[] args) {
//	
//		
////		Company c=new Company(); //later
////		Company c=null;
////		c.dev.code(); //later
//		
//		Resource r=new ClassPathResource("config.xml");
//		
//		BeanFactory bf=new XmlBeanFactory(r);
//		
//		Company c=(Company)bf.getBean("com");
//		System.out.println(c);
//		
//		// by default  same object reference  because default class is singleton
//		Company c1=(Company)bf.getBean("com");
//		Company c2=(Company)bf.getBean("com");
//		Company c3=(Company)bf.getBean("com");
//		Company c4=(Company)bf.getBean("com");
//		Company c5=(Company)bf.getBean("com");
//		
//		System.out.println(c1);
//		System.out.println(c2);
//		System.out.println(c3);
//		System.out.println(c4);
//		System.out.println(c5);
//		
//		
//		
//		Developer d=(Developer) bf.getBean("d");
//		System.out.println(d);
//		
//		Desktop d1=(Desktop) bf.getBean("desk");
//		System.out.println(d1);
//		d1.compile();
//		
////	System.out.println(bf.getBean("com")); //first_spring_project.Company@74650e52
////	System.out.println(bf.getBean("d"));  //first_spring_project.Developer@4b1c1ea0
////	System.out.println(bf.getBean("l"));   //first_spring_project.Laptop@17579e0f
////	System.out.println(bf.getBean("desk"));  //first_spring_project.Desktop@3712b94
//	
	}
	
	



	



