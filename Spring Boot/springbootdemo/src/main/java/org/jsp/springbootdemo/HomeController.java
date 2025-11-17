package org.jsp.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //combination of @Controller+ ResponseBody
//@Controller
public class HomeController {
//	@ResponseBody
	@RequestMapping("/hi")
	
	public String hi() {
		System.out.println("hi method called");
		return "hello from homeController";
	}
	//http://localhost:8080/hi 
	//http://localhost:8080/hello
	//http://localhost:8080/user
	//http://localhost:8080/add?num1=10&num2=20
	
//	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
	return  "hello method called";
	}
	
//	@ResponseBody
	@RequestMapping("/user")
	public User user() {
		User u=new User();
		u.setId(101);
		u.setName("hums");
		u.setEmail("humadeveloper");
		u.setPhone("98980459650");
		u.setPassword("123");
		
		return u;//  {  "id": 101, "name": "hums", "email": "humadeveloper","phone": "98980459650","password": "123"}
	}
	
//	@ResponseBody
	@RequestMapping("/add")
	public String add(@RequestParam int num1,@RequestParam int num2) {
//		return ""+(2+2);
		return ""+(num1+num2);
	}
	
	
	@RequestMapping("/sub")
	public String sub(@RequestParam int num1,@RequestParam int num2) {

		return ""+(num1-num2);
	}
	
	@RequestMapping("/data")
	public String data(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam String phone,@RequestParam String password) {

		return ""+(id+" "+name+ " "+email+" "+phone+" "+password);
	}
	

}
