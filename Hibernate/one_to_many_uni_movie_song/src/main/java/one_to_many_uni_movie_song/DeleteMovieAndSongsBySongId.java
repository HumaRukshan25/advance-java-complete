package one_to_many_uni_movie_song;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DeleteMovieAndSongsBySongId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        int songId = 6; // specify the Song ID you want to delete

        et.begin();
        // Find the song by ID
        Song song = em.find(Song.class, songId);

        if (song != null) {
            // Get all movies
            List<Movie> movies = em.createQuery("from Movie", Movie.class).getResultList();
            boolean songFoundInMovies = false;

            for (Movie movie : movies) {
                // Check if the movie contains the song
                if (movie.getSongs().remove(song)) {
                    // If the song was removed from the movie, mark it
                    songFoundInMovies = true;
                    em.merge(movie);
                    System.out.println("Removed song from movie: " + movie.getTitle());
                }
            }

            // Now delete the song itself
            em.remove(song);
            System.out.println("Deleted song with ID: " + songId);

            // Optionally, if you want to delete movies that contained the song:
            if (songFoundInMovies) {
                for (Movie movie : movies) {
                    if (movie.getSongs().isEmpty()) {
                        em.remove(movie);
                        System.out.println("Deleted movie: " + movie.getTitle());
                    }
                }
            }

        } else {
            System.out.println("No song found with ID: " + songId);
        }

        et.commit();
        em.close();
    }
}
