package second_spring_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.CommandLinePropertySource;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext ac=new ClassPathXmlApplicationContext("config.xml");
		//toavoid xml file we use annotationconfigapplucationcontext
		ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
		
//		Person p=ac.getBean(Person.class);
////		System.out.println(p);//second_spring_project.Person@38c6f217
//		System.out.println(p.v);
//		p.v.start();
//		p.v.stop();
////		System.out.println(ac);
		
	ArrayList al=ac.getBean(ArrayList.class);
		System.out.println(al);
		
		HashMap hm=ac.getBean(HashMap.class);
		System.out.println(hm);
		
		HashSet hs=ac.getBean(HashSet.class);
		System.out.println(hs);
	}
}
