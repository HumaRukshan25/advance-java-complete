package org.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaticPageController {

    @RequestMapping("/about")
    public ModelAndView aboutPage(ModelAndView mv) {
        mv.setViewName("about.jsp");
        return mv;
    }

    @RequestMapping("/contact")
    public ModelAndView contactPage(ModelAndView mv) {
        mv.setViewName("contact.jsp");
        return mv;
    }
}
