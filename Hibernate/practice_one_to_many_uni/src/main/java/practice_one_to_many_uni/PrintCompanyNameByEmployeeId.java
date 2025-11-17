package practice_one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PrintCompanyNameByEmployeeId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

        int eid = 8; // Employee ID to search before 3 eid 
        
        Query q=em.createQuery("select c from Company c");
        List<Company> cl=q.getResultList();
        
//        ListIterator<Company> litr=cl.listIterator();
//        
//        while(litr.hasNext() ) {
//        Company c=	litr.next();
//        List<Employee> el=c.getEmps();
//        for(Employee e:el) {
//        if(e.getId()==eid) {
//        	System.out.println(c.getName());
//        }
//        }
        //--------------
        
Iterator<Company> itr=cl.iterator();
        
        while(itr.hasNext() ) {
        Company c=	itr.next();
        List<Employee> el=c.getEmps();
        for(Employee e:el) {
        if(e.getId()==eid) {
        	System.out.println(c.getName());
        }
        }
        
        
        
        
//        	System.out.println("hi");
//        	System.out.println(litr.previous());	
        }
        

        
        
//?---- from chatgpt
        
//        List<Company> companies = em.createQuery(
//                "SELECT c FROM Company c JOIN c.emps e WHERE e.id = :eid", Company.class)
//                .setParameter("eid", eid)
//                .getResultList();
//        if (!companies.isEmpty()) {
//            System.out.println("Company Name: " + companies.get(0).getName());
//        } else {
//            System.out.println("No company found for Employee ID: " + eid);
//        }
//
//        em.close();

        
       
    }
}
