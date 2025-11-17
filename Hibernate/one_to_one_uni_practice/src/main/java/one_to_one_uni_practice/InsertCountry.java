package one_to_one_uni_practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InsertCountry {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Country Name and Capital City Name");
        
        Country c = new Country(0,sc.next(),sc.next(),null);
      
        
        et.begin();
        em.persist(c);
        et.commit();
        
        System.out.println("Country saved successfully.");
       
    }
}
