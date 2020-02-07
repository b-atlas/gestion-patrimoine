package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "monument")
public class Monument {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NotNull(message = "est obligatoire")
	@Size(min = 1, message = "est obligatoire")
	private String name;

	@Column(name = "age")
	@NotNull(message = "est obligatoire")
	@Min(value = 1, message = "doit etre supérieur à 0")
	private int age;

	@Column(name = "surface")
	@NotNull(message = "est obligatoire")
	@Min(value = 1, message = "doit etre supérieur à 0")
	private double surface;

	public Monument() {
	}

	public Monument(String name, int age, double surface) {
		this.name = name;
		this.age = age;
		this.surface = surface;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}
}
