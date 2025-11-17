package one_to_one_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeletePersonByPanCardId {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		int pcid=1;
		
		PanCard pc=em.find(PanCard.class, pcid);
		
		Query q=em.createQuery("from Person");
		
		List<Person> p1=q.getResultList();
		
		for(Person p:p1) {
			
			if(p.getPc().getId()==pcid) {
				et.begin();
				em.remove(p);
				et.commit();
				
				
			}
			
		}
	}
}
