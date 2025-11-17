package first_spring_project;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//19/11/2024
public class Test3 {
	public static void main(String[] args) {
		System.out.println("start");
//	//?? beanfactory: LAZY instantation  ,only supports xml,slow application,deprecated
//		Resource r=new ClassPathResource("config.xml");
//		BeanFactory bf=new XmlBeanFactory(r);
//		
//		Company c=(Company) bf.getBean("com");
//		bf.getBean("dev");
//		bf.getBean("lap");
//		bf.getBean("desk");

		//?? application context :EAGER instantation,supports xml and java,not deprecated
		
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		
	    ac.getBean("com");//in company constructor
		ac.getBean("dev");//in developer constructor
		ac.getBean("lap");//in laptop constructor
		ac.getBean("desk");//in desktop constructor
		
		System.out.println("end");
	}

}
