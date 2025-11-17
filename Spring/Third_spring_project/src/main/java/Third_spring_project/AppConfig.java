package Third_spring_project;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "Third_spring_project") // Replace with your package name
//@ComponentScan({"my_context","Third_spring_projec"})  // if u want to scan more than one package 
public class AppConfig {
	
	@Bean
	EntityManager entityManager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
		
	}
	@Bean
	Scanner scanner() {
		return new Scanner(System.in);
	}

}
