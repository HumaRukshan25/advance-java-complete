package one_to_one_uni_p1;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class InsertLibrary {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Library Name and Books Count");
        
        Library library = new Library(0, sc.next(), sc.nextInt(),null);

        et.begin();
        em.persist(library);
        et.commit();
        
        System.out.println("Library saved successfully.");
    }
}
