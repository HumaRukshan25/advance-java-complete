package org.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	static EntityManager em=emf.createEntityManager();
	@RequestMapping("/reg")
	public ModelAndView sameUser(@RequestParam String name,
			@RequestParam String email,
			@RequestParam long phone,
			@RequestParam int age,
			@RequestParam String password)
			{
		
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		User user=em.merge(new User(0,name,email,phone,age,password));
		et.commit();
		
		System.out.println(name);
		ModelAndView mv=new ModelAndView();
//		mv.setViewName("reg.jsp");
		mv.setViewName("success.jsp");
		
		mv.addObject("id",user.getId());
		mv.addObject("name",user.getName());
		return mv;
		
	}
	@RequestMapping("/regpage")
	public ModelAndView regPage() {
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("reg.jsp");
		return mv;
		
	}
	@RequestMapping("/all")
	public ModelAndView findAllUsers() {
		List ul=em.createQuery("from User").getResultList();
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("allusers.jsp");
		mv.addObject("users",ul);
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteUserById(@RequestParam int id) {
		User u=em.find(User.class, id);
		if(u!=null) {
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.remove(u);
			et.commit();
			
			return findAllUsers();
		}
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("index.jsp");
		mv.addObject("msg","Invalid user id unable to delete");
		
		return mv;
	}

	
	@RequestMapping("/updatepage")
	public ModelAndView updateUserById(@RequestParam int id) {
		User user=em.find(User.class, id);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("update.jsp");
		mv.addObject("u",user);
		
		return mv;	
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam int id,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam long phone,
			@RequestParam int age,
			@RequestParam String password) {
		User u=em.find(User.class, id);
		u.setName(name);
		u.setEmail(email);
		u.setPhone(phone);
		u.setAge(age);
		u.setPassword(password);
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(u);
		et.commit();
		
		
		return findAllUsers();	
	}

}
