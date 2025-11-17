package one_to_many_uni_movie_song;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddSongToExistingMovie {
    private static Scanner sc;

	public static void main(String[] args) {
        sc = new Scanner(System.in);
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        System.out.print("Enter the movie ID: ");
        int mid = sc.nextInt();

        // Corrected the find method to use mid instead of em
        Movie m = em.find(Movie.class, mid);

        if (m == null) {
            System.err.println("Invalid ID entered");
            return;
        }

        System.out.println("Enter the song title:");
        String songTitle = sc.next();
        System.out.println("Enter the song artist:");
        String songArtist = sc.next();

        Song s = new Song(songTitle, songArtist);

        // Retrieve the current list of songs and add the new song
        List<Song> sl = m.getSongs();
        sl.add(s);
        m.setSongs(sl);

        et.begin();
        em.persist(s);  // Persist the new song
        em.merge(m);    // Merge the updated movie with the new song
        et.commit();
        
        System.out.println("Done.");
    }
}
