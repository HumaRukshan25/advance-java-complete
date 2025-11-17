package practice_one_to_many_uni;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteEmployeeFromCompany {
	public static void main(String[] args) {
		 EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		  EntityTransaction et=em.getTransaction();
		  int eid=1;
		  
		  Query q=em.createQuery("from Company");
	      List<Company> cl=q.getResultList();
	      
	      
	      
	      for(Company c:cl) {
	    	  ArrayList<Employee> ee=new ArrayList<Employee>();
	    	  List<Employee> emps=c.getEmps();
	    	  for(Employee e:emps) {
	    		  if(e.getId()!=eid) {
	    			  ee.add(e);
	    		  }
	    		  else {
//	    			  emps.remove(e);
	    			  c.setEmps(emps);
	    			  et.begin();
	    			  em.merge(c);
	    			  et.commit();
	    			 
	    		  }
	    	  }
	      }  
	   
	}

}
