package practice_one_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapCompanyAndEmployees {
public static void main(String[] args) {
	EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	int cid=7;
	
	int eid=8;
	
	Company c=em.find(Company.class, cid);

	
	Employee e=em.find(Employee.class, eid);
	
	 List<Employee> emps= c.getEmps();
	 emps.add(e);
	 c.setEmps(emps);
	 
	 et.begin();
	 em.merge(c);
	 et.commit();
	 System.out.println("done");	
	
}
}
