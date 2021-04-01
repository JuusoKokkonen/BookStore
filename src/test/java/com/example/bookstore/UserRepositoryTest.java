package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	
	@Autowired
	private UserRepository uRepository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User User = uRepository.findByUsername("user");
		
		assertThat(User.getUsername()).isEqualTo("user");
	}
	
	@Test
	public void addAndDeleteUser() {
		User testUser = new User("Testaaja", "PasswordHash", "USER");
		uRepository.save(testUser);
		User user = uRepository.findByUsername("Testaaja");
		assertThat(user.getUsername()).isEqualTo("Testaaja");
		uRepository.deleteById(user.getId());
				
	}
}