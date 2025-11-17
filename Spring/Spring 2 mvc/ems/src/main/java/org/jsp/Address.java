package org.jsp;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
