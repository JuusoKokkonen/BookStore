package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	
	@Autowired
	private CategoryRepository cRepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> category = cRepository.findByName("Comic");
		
		assertThat(category).hasSize(1);
		assertThat(category.get(0).getName()).isEqualTo("Comic");
	}
	
	@Test
	public void addAndDeleteCategory() {
		Category testCategory = new Category("Test");
		cRepository.save(testCategory);
		List<Category> categories = cRepository.findByName("Test");
		assertThat(categories.get(0).getName()).isEqualTo("Test");
		cRepository.deleteById(categories.get(0).getCategoryid());
		List<Category> categoriesNew = cRepository.findByName("Test");
		assertThat(categoriesNew.size()).isEqualTo(0);
				
	}
}