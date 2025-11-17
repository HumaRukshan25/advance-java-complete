package many_to_one_uni;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteTeamByPlayerId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player ID to delete associated team: ");
        int playerId = sc.nextInt();

        Player player = em.find(Player.class, playerId);
        if (player != null) {
            Team team = player.getTeam();
            if (team != null) {
                et.begin();

                // Remove all players associated with the team
                Query query = em.createQuery("DELETE FROM Player p WHERE p.team.id = :teamId");
                query.setParameter("teamId", team.getId());
                query.executeUpdate();

                // Remove the team after deleting associated players
                em.remove(team);

                et.commit();
                System.out.println("Team and all associated players deleted successfully.");
            } else {
                System.out.println("No team associated with Player ID " + playerId);
            }
        } else {
            System.out.println("Invalid player ID.");
        }

      
    }
}
