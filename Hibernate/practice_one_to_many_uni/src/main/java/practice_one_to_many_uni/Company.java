package practice_one_to_many_uni;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String loc;
	private String doe;
	
	@OneToMany
	List<Employee> emps;
	
	
public Company() {
		
	}
	
	public Company(int id, String name, String loc, String doe, List<Employee> emps) {
	super();
	this.id = id;
	this.name = name;
	this.loc = loc;
	this.doe = doe;
	this.emps = emps;
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

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", loc=" + loc + ", doe=" + doe + ", emps=" + emps + "]";
	}


}
