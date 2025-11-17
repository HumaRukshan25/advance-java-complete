package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PrintPlayerNameByPlayerId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter player ID:");
        int pId = sc.nextInt();

        // Find the player by ID
        Player player = em.find(Player.class, pId);

        if (player == null) {
            System.out.println("Invalid player ID");
        } else {
           
            int teamId = player.getTeam().getId();
            Query query = em.createQuery("SELECT p FROM Player p WHERE p.team.id = :teamId", Player.class);
            query.setParameter("teamId", teamId);
            List<Player> players = query.getResultList();

            System.out.println("Players in the same team:");
            for (Player p : players) {
                System.out.println(p.getName());
            }
        }

        System.out.println("Done🙂");
       
    }
}
