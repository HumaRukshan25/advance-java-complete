package ums;

import java.io.ObjectInputFilter.Config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class User {
//	@Value("101")
 int id;
//	@Value("allen")
	 String name;
	 
	 @Override
	public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
	
	
	public static void main(String[] args) {
Resource r=new ClassPathResource("config.xml");
		
		BeanFactory bf=new XmlBeanFactory(r);
		
//		ApplicationContext bf=new ClassPathXmlApplicationContext("Config.xml");

//		User u=new User();
//		System.out.println(u);
		User u1=(User)bf.getBean("u");
		User u2=(User)bf.getBean("u");
		User u3=(User)bf.getBean("u");
		User u4=(User)bf.getBean("u");
		User u5=(User)bf.getBean("u");
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		System.out.println(u4);
		System.out.println(u5);
		
	}
	

}
