package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import com.example.bookstore.web.BookController;
import com.example.bookstore.web.CategoryController;
import com.example.bookstore.web.RestController;
import com.example.bookstore.web.UserDetailServiceImpl;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bController;
	
	@Autowired
	private CategoryController cController;
	
	@Autowired
	private RestController rController;
	
	@Autowired
	private UserDetailServiceImpl userDetails;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(bController).isNotNull();
		assertThat(cController).isNotNull();
		assertThat(rController).isNotNull();
		assertThat(userDetails).isNotNull();
	}

}
