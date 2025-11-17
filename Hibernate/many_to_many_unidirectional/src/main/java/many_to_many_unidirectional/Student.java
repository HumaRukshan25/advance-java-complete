package many_to_many_unidirectional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_batch", // Join table name
        joinColumns = @JoinColumn(name = "student_id"), // Foreign key column for Student
        inverseJoinColumns = @JoinColumn(name = "batch_id") // Foreign key column for Batch
    )
    private Set<Batch> batches = new HashSet<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
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

    public Set<Batch> getBatches() {
        return batches;
    }

    public void setBatches(Set<Batch> batches) {
        this.batches = batches;
    }
}
