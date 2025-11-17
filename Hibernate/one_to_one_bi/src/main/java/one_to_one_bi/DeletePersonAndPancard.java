package one_to_one_bi;
//assignment
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeletePersonAndPancard {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Person ID to delete:");
        int personId = sc.nextInt();
        Person person = em.find(Person.class, personId);

        if (person != null) {
            PanCard pc = person.getPc();

            et.begin();
            if (pc != null) {
                em.remove(pc);  // Remove associated PanCard
            }
            em.remove(person);  // Remove Person
            et.commit();

            System.out.println("Deletion successful!");
        } else {
            System.out.println("Person not found!");
        }
      
    }
}
