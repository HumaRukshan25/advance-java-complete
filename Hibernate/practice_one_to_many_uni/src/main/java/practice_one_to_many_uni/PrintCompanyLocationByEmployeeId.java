package practice_one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PrintCompanyLocationByEmployeeId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

        int eid = 8; // Employee ID to search before 3 eid 
        
        Query q=em.createQuery("select c from Company c");
        List<Company> cl=q.getResultList();
        //---------
        
Iterator<Company> itr=cl.iterator();
        
        while(itr.hasNext() ) {
        Company c=	itr.next();
        List<Employee> el=c.getEmps();
        for(Employee e:el) {
        if(e.getId()==eid) {
        	System.out.println(c.getLoc());
        }
        }
        
        
        
        
        }
        

        
  
       
    }
}
