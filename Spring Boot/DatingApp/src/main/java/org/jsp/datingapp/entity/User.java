package org.jsp.datingapp.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

import org.jsp.datingapp.util.Gender;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Gender interestedIn;

    private int age;

    @ElementCollection
    private List<String> interests;
}
