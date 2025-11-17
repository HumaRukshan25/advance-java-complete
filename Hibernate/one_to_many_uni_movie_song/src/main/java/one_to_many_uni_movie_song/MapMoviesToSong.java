package one_to_many_uni_movie_song;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapMoviesToSong {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        // Specify song IDs
        int songId1 = 1;
        int songId2 = 2;
        int songId3 = 3;
        int songId4 = 4;
        int songId5 = 5;
        
        // Specify movie ID
        int movieId = 1;
        
        // Retrieve Song entities by ID
        Song song1 = em.find(Song.class, songId1);
        Song song2 = em.find(Song.class, songId2);
        Song song3 = em.find(Song.class, songId3);
        Song song4 = em.find(Song.class, songId4);
        Song song5 = em.find(Song.class, songId5);
        
        // Retrieve Movie entity by ID
        Movie movie = em.find(Movie.class, movieId);
        
        // Add songs to a list
        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        
        // Set the list of songs in the movie
        movie.setSongs(songs);
        
        // Begin transaction, merge changes, and commit
        et.begin();
        em.merge(movie);
        et.commit();
        
        System.out.println("Songs have been successfully mapped to the movie.");
        
        em.close();
    }
}
