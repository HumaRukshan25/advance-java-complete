package one_to_many_uni_movie_song;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchSongNameBySongId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        int songId = 6; // specify the Song ID you want to fetch

        // Find the Song entity by ID
        Song song = em.find(Song.class, songId);

        if (song != null) {
            // If the song is found, print its title and artist
            System.out.println("Song ID: " + song.getId());
            System.out.println("Song Title: " + song.getTitle());
            System.out.println("Song Artist: " + song.getArtist());
        } else {
            // If no song is found with the specified ID
            System.out.println("No song found with ID: " + songId);
        }

        em.close();
    }
}
