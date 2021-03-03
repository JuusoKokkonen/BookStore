package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	// Attributes
	@Id
	
	private String name;
	
	// Constructors
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {
		super();
		this.name = null;
	}

	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	// ToString
	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
	
	
	
	
}
