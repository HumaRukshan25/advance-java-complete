package one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;
//assignment
public class ReadPersonAndPancard {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Person ID to retrieve:");
        int personId = sc.nextInt();
        Person person = em.find(Person.class, personId);

        if (person != null) {
            System.out.println("Person Name: " + person.getName());
            System.out.println("Person Phone: " + person.getPhone());
            
            PanCard pc = person.getPc();
            if (pc != null) {
                System.out.println("PanCard Number: " + pc.getpNo());
                System.out.println("PanCard Pin: " + pc.getPin());
            }
        } else {
            System.out.println("Person not found!");
        }
      
    }
}
