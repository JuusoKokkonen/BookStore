package com.example.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryid;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
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
	
	public List<Book> getBooks() {
		return books;
	}

	public void setCategory(List<Book> books) {
		this.books = books;
	}
	
	public Long getId() {
		return categoryid;
	}

	
	// ToString
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + ", books=" + books + "]";
	}

	
}
