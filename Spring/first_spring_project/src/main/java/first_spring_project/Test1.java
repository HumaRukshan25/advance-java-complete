package first_spring_project;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//if u want to run green icon run for test1,test2,test3 respectively
public class Test1 {
	
	
	public static void main(String[] args) {
		Resource r=new ClassPathResource("config.xml");//giving resource using classpathresource
		BeanFactory bf=new XmlBeanFactory(r);// constructor will accept resource object
		
		//singleton ie  same address for every object
		//if scope given in bean as prototype then different address
		Company c=(Company) bf.getBean("com");//in company constructor
//		System.out.println(c);
		
//		Developer d1=(Developer)bf.getBean("dev");
//		System.out.println(d1);
//		c.setDev(d1);
		
//		c1.dev=dev; //dependency injection
		
		System.out.println(c.pinCode);//560045
		System.out.println(c.name);	//Google
		System.out.println(c.dev);//null
		System.out.println(c.lap);//null
		System.out.println(c.desk);//null
		System.out.println(c.devNames);
		System.out.println(c.deptAndDev);
		
		
		
	}

}
