package one_to_one_bi;
//assignment
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class UpdatePersonAndPancard {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Person ID to update:");
        int personId = sc.nextInt();
        Person person = em.find(Person.class, personId);

        if (person != null) {
            System.out.println("Enter new name:");
            person.setName(sc.next());
            System.out.println("Enter new phone:");
            person.setPhone(sc.nextLong());

            PanCard pc = person.getPc();
            if (pc != null) {
                System.out.println("Enter new PanCard number:");
                pc.setpNo(sc.next());
                System.out.println("Enter new PanCard pin:");
                pc.setPin(sc.nextInt());
            }

            et.begin();
            em.merge(person);
            em.merge(pc);
            et.commit();
            
            System.out.println("Update successful!");
        } else {
            System.out.println("Person not found!");
        }
     
    }
}
