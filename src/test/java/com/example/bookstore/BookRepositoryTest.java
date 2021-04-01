package com.example.bookstore;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bRepository;
	
	@Autowired
	private CategoryRepository cRepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bRepository.findByTitle("Testi");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Testi");
	}
	
	@Test
	public void addAndDeleteBook() {
		Book testbook = new Book("Testi123", "Testi", "2021", "testi", (long) 20, cRepository.findByName("Comic").get(0));
		bRepository.save(testbook);
		List<Book> books = bRepository.findByTitle("Testi123");
		assertThat(books.get(0).getTitle()).isEqualTo("Testi123");
		bRepository.deleteById(books.get(0).getId());
		List<Book> booksNew = bRepository.findByTitle("Testi123");
		assertThat(booksNew.size()).isEqualTo(0);
				
	}
}
