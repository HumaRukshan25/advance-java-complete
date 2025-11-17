package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class DeletePlayerByPlayerId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player ID to delete: ");
        int playerId = sc.nextInt();

        Player player = em.find(Player.class, playerId);
        if (player != null) {
            et.begin();
            em.remove(player);
            et.commit();
            System.out.println("Player with ID " + playerId + " deleted successfully.");
        } else {
            System.out.println("Invalid player ID.");
        }
    }
}
