package org.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private EntityManager em;

    @RequestMapping("/addAddress")
    public ModelAndView addAddressPage(ModelAndView mv, @RequestParam int employeeId) {
        mv.addObject("employeeId", employeeId);
        mv.setViewName("address.jsp");
        return mv;
    }

    @RequestMapping("/saveAddress")
    public ModelAndView saveAddress(ModelAndView mv,
                                     @RequestParam String street,
                                     @RequestParam String city,
                                     @RequestParam String state,
                                     @RequestParam String zip,
                                     @RequestParam int employeeId) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Employee employee = em.find(Employee.class, employeeId);
        Address address = new Address(0, street, city, state, zip, employee);
        em.persist(address);
        et.commit();

        mv.setViewName("index.jsp");
        return mv;
    }

    @RequestMapping("/viewAddress")
    public ModelAndView viewAddresses(ModelAndView mv, @RequestParam int employeeId) {
        List<Address> addresses = em.createQuery("SELECT a FROM Address a WHERE a.employee.id = :employeeId", Address.class)
                                    .setParameter("employeeId", employeeId)
                                    .getResultList();
        mv.addObject("addresses", addresses);
        mv.addObject("employeeId", employeeId);
        mv.setViewName("viewaddress.jsp");
        return mv;
    }
    
    @RequestMapping("/editAddress")
    public ModelAndView editAddress(@RequestParam int id, ModelAndView mv) {
        Address address = em.find(Address.class, id);
        mv.addObject("address", address);
        mv.setViewName("editaddress.jsp");
        return mv;
    }
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public ModelAndView updateAddress(@RequestParam int id,
                                       @RequestParam String street,
                                       @RequestParam String city,
                                       @RequestParam String state,
                                       @RequestParam String zip,
                                       ModelAndView mv) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Address address = em.find(Address.class, id);
        if (address != null) {
            address.setStreet(street);
            address.setCity(city);
            address.setState(state);
            address.setZip(zip);
            em.merge(address);
        }
        et.commit();

        mv.setViewName("redirect:/viewAddress?employeeId=" + address.getEmployee().getId());
        return mv;
    }

    @RequestMapping("/deleteAddress")
    public ModelAndView deleteAddress(@RequestParam int id, ModelAndView mv) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Address address = em.find(Address.class, id);
        if (address != null) {
            em.remove(address);
        }
        et.commit();

        mv.setViewName("redirect:/viewAddress?employeeId=" + address.getEmployee().getId());
        return mv;
    }

}
