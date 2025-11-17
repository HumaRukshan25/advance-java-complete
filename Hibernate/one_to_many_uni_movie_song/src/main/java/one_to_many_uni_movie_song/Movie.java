package one_to_many_uni_movie_song;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;

    @OneToMany
    private List<Song> songs;

    public Movie() {}

    public Movie(String title, String genre, List<Song> songs) {
        this.title = title;
        this.genre = genre;
        this.songs = songs;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	

   

   
}
