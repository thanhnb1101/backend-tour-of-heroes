package com.demo.heroes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Hero")
public class Hero {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fullName")
	private String name;
}
