package one_to_one_uni_practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapCountryAndPresident {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Country c = em.find(Country.class, 1);
        President p = em.find(President.class, 1);
 
            c.setPresident(p);

            et.begin();
            em.merge(c);
            et.commit();

            System.out.println("Country and President mapped successfully.");
        
          
        
    }
}
