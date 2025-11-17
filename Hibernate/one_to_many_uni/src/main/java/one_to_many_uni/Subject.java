package one_to_many_uni;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int sem;
	private String branch;
	
	@OneToMany
	
	private List<Module> modules;//extra table(Relationship table) is created by hibernate because of list sid(fk) and mid(pk)
	
	public Subject() {
		
	}
	public Subject(int id, String name, int sem, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.sem = sem;
		this.branch = branch;
	}
	
	
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", sem=" + sem + ", branch=" + branch + ", modules=" + modules
				+ "]";
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
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public void setModules(List<Module> modules2) {
		// TODO Auto-generated method stub
		this.modules= modules2;
		
	}
	
	

}
