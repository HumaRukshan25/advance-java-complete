package one_to_many_uni_movie_song;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class FetchSongByMovieId {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

        int movieId = 3; // specify the Movie ID for which you want to fetch songs

        // Find the Movie entity by ID
        Movie movie = em.find(Movie.class, movieId);

        if (movie != null) {
            List<Song> songs = movie.getSongs();

            System.out.println("Songs for movie: " + movie.getTitle());
            for (Song song : songs) {
                System.out.println("Song Title: " + song.getTitle() + ", Artist: " + song.getArtist());
            }
        } else {
            System.out.println("No movie found with ID: " + movieId);
        }

        em.close();
    }
}
