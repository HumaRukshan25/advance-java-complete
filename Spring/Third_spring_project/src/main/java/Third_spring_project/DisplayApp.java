package Third_spring_project;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DisplayApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        EntityManager em = ac.getBean(EntityManager.class);
        Query q = em.createQuery("from User");
        List<User> ul = q.getResultList();
        for (User u : ul) {
            System.out.println(u);
        }
    }
}
