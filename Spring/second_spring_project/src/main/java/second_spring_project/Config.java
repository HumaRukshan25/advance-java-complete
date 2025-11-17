package second_spring_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("second_spring_project")//scan for the components in this package
public class Config {
	
	@Bean
	ArrayList arrayList() {
		ArrayList al=new ArrayList();
//		al.add(10);
//		al.add(20);
//		al.add(30);
//		al.add(40);
//		
//		return al;
		
		return new ArrayList() {{add(10);add(20);add(30);add(40);}};  //double braces initialization
		
	}
	
	@Bean
	HashMap hashmap() {
		return new HashMap() {{put(1,2);put(2,2);put(3,2);put(4,3);put(4,6);put(4,1);}}; 
	//for put(4,anything) new value will come
		
	}
	@Bean
	HashSet hashset() {
		return new HashSet() {{add(10);add(20);add(30);add(40);}}; 
	//for put(4,anything) new value will come
		
	}
	


	
}

