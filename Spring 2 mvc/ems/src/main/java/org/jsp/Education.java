package org.jsp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Education {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String uname;
	private String cname;
	private int yop;
	private double cgpa;
	
	


}



