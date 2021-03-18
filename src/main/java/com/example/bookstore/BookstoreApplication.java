package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository, UserRepository uRepository) {
		return (args) -> {
			Category category1 = new Category("Comic");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Science");
			
			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
			
			Book demo1 = new Book("Testi", "Testiauthor", "2021", "testi", (long) 20, cRepository.findByName("Comic").get(0));
			Book demo2 = new Book("Demo", "Demo-author", "2010", "ISBN", (long) 19, cRepository.findByName("Fantasy").get(0));
			Book demo3 = new Book(":)", "Testiauthor", "2021", "testi", (long) 20, cRepository.findByName("Science").get(0));
			
			bRepository.save(demo1);
			bRepository.save(demo2);
			bRepository.save(demo3);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);

			
			log.info("Fetch all the books");
			for (Book book : bRepository.findAll()) {
			   log.info(book.toString());
			}
			
			log.info("Fetch all the categories");
			for (Category category : cRepository.findAll()) {
			   log.info(category.toString());
			}
			
			log.info("Fetch all users");
			for (User user : uRepository.findAll()) {
			   log.info(user.toString());
			}
			
		};
	}
	
}

