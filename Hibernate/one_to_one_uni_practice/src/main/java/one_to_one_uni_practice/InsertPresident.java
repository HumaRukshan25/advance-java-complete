
package one_to_one_uni_practice;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InsertPresident {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter President Name and Age");
        
        President p = new President(0,sc.next(),sc.nextInt());
       

        et.begin();
        em.persist(p);
        et.commit();

        System.out.println("President saved successfully.");
      
    }
}
