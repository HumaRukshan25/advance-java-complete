package org.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EntityManager em;
    
     


    // Employee creation page
    @RequestMapping("/employee")
    public ModelAndView employeePage() {
    	 ModelAndView mv=new ModelAndView();
        mv.setViewName("employee.jsp");
        return mv;
    }
    



  

//    // Save new employee
//    @RequestMapping("/saveEmployee")
//    public ModelAndView saveEmployee(ModelAndView mv,
//                                      @RequestParam String name,
//                                      @RequestParam String department) {
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        em.persist(new Employee(0, name, department, null));
//        et.commit();
//
//        mv.setViewName("index.jsp");
//        return mv;
//    }
 
    @RequestMapping("/saveEmployee")
    public ModelAndView saveEmployee(
        ModelAndView mv,
        @RequestParam(name = "name") String name,
        @RequestParam(name = "department") String department) {
        
        // Start transaction
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            // Persist new Employee
            em.persist(new Employee(0, name, department));
            et.commit();
            
         
            mv.addObject("msg","Account created sucessfully");
            
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); // Rollback in case of an exception
            }
            throw e; // Re-throw the exception
        }

        // Redirect to index.jsp
        mv.setViewName("index.jsp");
 
        return mv;
    }



    // View all employees
    @RequestMapping("/employees")
    public ModelAndView viewAllEmployees(ModelAndView mv) {
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        mv.addObject("employees", employees);
        mv.setViewName("viewemployees.jsp");
        return mv;
    }

    // Delete employee
    @RequestMapping("/deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int id, ModelAndView mv) {
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            em.remove(employee);
        }
        et.commit();
        
        mv.setViewName("/employees");
        mv.addObject("msg1","Account deleted succesfully"); //on 26/03/2025
        
        return employeePage();
    }
    
    
    // Update employee page
    @RequestMapping("/editEmployee")
    public ModelAndView editEmployee(@RequestParam int id, ModelAndView mv) {
        Employee employee = em.find(Employee.class, id);
      
        mv.setViewName("editemployee.jsp");
        mv.addObject("employee", employee);
        return mv;
    }
    
    
    // Update employee
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@RequestParam int id,
                                        @RequestParam String name,
                                        @RequestParam String department,
                                        ModelAndView mv) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        
        Employee employee = em.find(Employee.class, id);
        
//        ModelAndView mv=new ModelAndView(); i have passed direct in parameter
        
        if (employee != null) {
            employee.setName(name);
            employee.setDepartment(department);
            em.merge(employee);
        }
        et.commit();

        mv.setViewName("redirect:/employees");
        return employeePage();
    }




    
}
