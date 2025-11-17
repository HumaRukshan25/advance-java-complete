package org.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam String n1,@RequestParam String n2) {
		System.out.println("Result :" +(n1+n2));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result",n1+n2);
		return mv;
	}

}
