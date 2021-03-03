package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository sRepository, CategoryRepository cRepository) {
		return (args) -> {
			Book demo1 = new Book("Testi", "Testiauthor", "2021", "testi", (long) 20);
			Book demo2 = new Book("Demo", "Demo-author", "2010", "ISBN", (long) 19);
			Book demo3 = new Book(":)", "Testiauthor", "2021", "testi", (long) 20);
			
			Category category1 = new Category("Comic");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Science");
			
			sRepository.save(demo1);
			sRepository.save(demo2);
			sRepository.save(demo3);
			
			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
		};
	}
	
}

