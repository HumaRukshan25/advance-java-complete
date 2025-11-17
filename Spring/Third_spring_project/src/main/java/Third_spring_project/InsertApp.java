package Third_spring_project;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InsertApp {
	
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner sc = ac.getBean(Scanner.class);

        User u = ac.getBean(User.class);
        System.out.println("Enter name:");
        u.setName(sc.next());
        System.out.println("Enter email:");
        u.setEmail(sc.next());
        System.out.println("Enter phone:");
        u.setPhone(sc.nextLong());
        System.out.println("Enter password:");
        u.setPassword(sc.next());

        EntityManager em = ac.getBean(EntityManager.class);
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(u);
        et.commit();
        System.out.println("User saved successfully");
    }
}
