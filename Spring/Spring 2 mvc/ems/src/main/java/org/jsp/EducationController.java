package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EducationController {

	@Autowired
	private EntityManager em;
//    static EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

    @RequestMapping("/savepage")
    public ModelAndView savePage(ModelAndView mv) {
        mv.setViewName("save.jsp");
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(ModelAndView mv,
                             @RequestParam String uname,
                             @RequestParam String cname,
                             @RequestParam int yop,
                             @RequestParam double cgpa) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(new Education(0, uname, cname, yop, cgpa));
        et.commit();

        mv.setViewName("index.jsp");
    
        return mv;
    }

    @RequestMapping("/all")
    public ModelAndView viewAll(ModelAndView mv) {
        Query query = em.createQuery("SELECT e FROM Education e");
        List<Education> educations = query.getResultList();
        mv.addObject("educations", educations);
        mv.setViewName("viewall.jsp");
        return mv;
    }

    @RequestMapping("/editpage")
    public ModelAndView editPage(ModelAndView mv, @RequestParam int id) {
        Education education = em.find(Education.class, id);
        mv.addObject("education", education);
        mv.setViewName("edit.jsp");
        return mv;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(ModelAndView mv,
                             @RequestParam int id,
                             @RequestParam String uname,
                             @RequestParam String cname,
                             @RequestParam int yop,
                             @RequestParam double cgpa) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Education education = em.find(Education.class, id);
        education.setUname(uname);
        education.setCname(cname);
        education.setYop(yop);
        education.setCgpa(cgpa);
        et.commit();

        mv.setViewName("index.jsp");
        return mv;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam int id, ModelAndView mv) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Education education = em.find(Education.class, id);
        if (education != null) {
            em.remove(education);
        }
        et.commit();
        


        mv.setViewName("index.jsp"); 
        return mv;
    }
}
