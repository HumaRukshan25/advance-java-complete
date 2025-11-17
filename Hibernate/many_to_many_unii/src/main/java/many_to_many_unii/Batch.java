package many_to_many_unii;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String code;
	//Eager and lazy done on 09/11/2024
	@ManyToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER) //cascade.persist the batch 
	List<Student> students;
	
	
	public Batch() {
		
	}

	public Batch(int id, String name, String code, List<Student> students) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.students = students;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", code=" + code + ", students=" + students + "]";
	}


}
