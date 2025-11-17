package org.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam int n1,@RequestParam int n2) {
		System.out.println("Result :" +(n1+n2));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result",n1+n2);
		return mv;
	}
	
	@RequestMapping("/sub")
	public ModelAndView sub(@RequestParam int n1,@RequestParam int n2) {
		System.out.println("Result :" +(n1-n2));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result",n1-n2);
		return mv;
	}
	
	@RequestMapping("/multi")
	public ModelAndView multi(@RequestParam int n1,@RequestParam int n2) {
		System.out.println("Result :" +(n1*n2));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result",n1*n2);
		return mv;
	}
	
	@RequestMapping("/div")
	public ModelAndView div(@RequestParam int n1,@RequestParam int n2) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		try {
			System.out.println(n1/n2);
			mv.addObject("result",(double)n1/n2);	
		} catch (ArithmeticException e) {
			mv.addObject("result","cant divide by zero");	
		}
		return mv;
	}
	

}
