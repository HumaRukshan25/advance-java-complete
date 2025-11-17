package one_to_one_uni_p1;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InsertAddress {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Address Street and City");
        
        Address address = new Address(0, sc.next(), sc.next());

        et.begin();
        em.persist(address);
        et.commit();

        System.out.println("Address saved successfully.");
    }
}
