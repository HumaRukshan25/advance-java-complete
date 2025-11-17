package practice_one_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Test1 {
	public static void main(String[] args) {
		EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int cid=2;
		
		Company c=em.find(Company.class, cid);
		System.out.println(c.getName());
	

		List<Employee> emps=c.getEmps();
	            for (Employee e:emps) {
	                System.out.println(e.getName());
	            }
	        
	       
		
	}

}
