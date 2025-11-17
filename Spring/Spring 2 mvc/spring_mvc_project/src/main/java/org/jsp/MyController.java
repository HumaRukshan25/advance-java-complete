package org.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //client request will be redirected to controller class
public class MyController {
	
	@RequestMapping("/print")
	public ModelAndView myPrint(@RequestParam String name,@RequestParam String place) {
		System.out.println(name);
		System.out.println(place);
		System.out.println(name +" is from"+ place);
		
		ModelAndView mv=new ModelAndView();//both model and view
		mv.setViewName("print.jsp");
		
		mv.addObject("name", name);
		mv.addObject("place", place);
		
		
		return mv;
//		return "print.jsp";
		//return type is string for before only view
		
	}
	
	
	@RequestMapping("/result")
	public String result() {
		System.out.println("hi huma");
		return "result.jsp";
	}
	

}
