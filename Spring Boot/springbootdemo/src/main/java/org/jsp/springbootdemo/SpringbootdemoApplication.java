package org.jsp.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication //starting point 
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(SpringbootdemoApplication.class, args);//ac will be created by run()
	
//		Car c=	ac.getBean(Car.class);
	
		
//	System.out.println(c.getId());	
//	System.out.println(c.getBrand());	
//	System.out.println(c.getPrice());	
//	System.out.println(c.getColor());	
//	
//	
//	System.out.println(c.getE().getName());
	
	}
	
//	@Bean
//	@EntityManager entityManager(){
//		return Persistence.createEnityManagerFactory("dev").createEntityManager();
//		
//	}

}
