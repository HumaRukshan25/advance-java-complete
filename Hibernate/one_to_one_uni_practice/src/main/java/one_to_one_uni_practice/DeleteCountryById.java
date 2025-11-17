package one_to_one_uni_practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeleteCountryById {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Country ID to delete:");
        
        int countryId = sc.nextInt();
        Country c = em.find(Country.class, countryId);
        
        
            et.begin();
            em.remove(c);
            et.commit();
            System.out.println("Country deleted successfully.");
     
           
        }
        
        
}
