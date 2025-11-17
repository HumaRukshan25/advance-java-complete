package one_to_many_many_to_one_bi;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//** lombok is a java annotation library  to avoid boiler plate code **//

//@Data //will give  equals hascode so use below separate annotations
@Getter //only to get getters 
@Setter //only setters
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String director;
	
	@OneToMany
	private List<Song> songs;
	
}

