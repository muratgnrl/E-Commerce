package com.example.authservice;

import com.example.authservice.entity.User;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


@SpringBootTest
class AuthServiceApplicationTests implements TestCrud {
		private final UserRepository userRepository;

		@Autowired
		AuthServiceApplicationTests(UserRepository userRepository) {
			this.userRepository = userRepository;
		}

		@Test
		@Override
		public void testCreate(){
			User user=User
					.builder()
					.userName("Görkem")
					.userLastName("Kaya")
					.mail("gorkem@gmail.com")
					.password("12345")
					.build();
			userRepository.save(user);

			assertNotNull(userRepository.findById(1L).get());
			//Todo nesne null ise assertionError hatası göndersin  1L birinci kayda göre verileri getir
		}



		@Test
		@Override
		public void testUpdate() {
			User user= userRepository.findByUserId(1L);
			user.setUserLastName("Soyturk");
			userRepository.save(user);
			assertNotEquals("Kaya",userRepository.findByUserId(1L).getUserLastName());

		}

		@Test
		@Override
		public void testList() {
			List<User> userList=userRepository.findAll();

			assertThat(userList).size().isGreaterThan(0);

		}

		@Test
		@Override
		public void testFindById() {

			User user = userRepository.findById(1L).get();
			assertEquals("Görkem", user.getUserName());

		}

		@Test
		@Override
		public void testLogin() {

			User user = User.builder()
					.userName("Görkem")
					.userLastName("Soyturk")
					.mail("gorkem@gmail.com")
					.password("12345")
					.build();

			userRepository.save(user);

			User loggedInUser = userRepository.findUserByMailAndPassword("gorkem@gmail.com", "12345");

			assertNotNull(loggedInUser);
			assertEquals("Görkem", loggedInUser.getUserName());
			assertEquals("Soyturk", loggedInUser.getUserLastName());
		}


		@Test
		@Override
		public void testDeleteById() {
			userRepository.deleteById(1L);

			assertThat(userRepository.existsById(1L)).isFalse();

		}
	}


