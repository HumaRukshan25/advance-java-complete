package first_spring_project;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// 18/11/2024
public class Test2 {
	public static void main(String[] args) {
		
	Resource r=new ClassPathResource("config.xml");
	BeanFactory bf=new XmlBeanFactory(r);
	
	Developer d=(Developer) bf.getBean("dev");//in developer constructor
	System.out.println(d.c);//null

	}
	

}
