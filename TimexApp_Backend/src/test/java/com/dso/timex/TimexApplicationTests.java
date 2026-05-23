package com.dso.timex;

import com.dso.timex.application.service.UserService;
import com.dso.timex.domain.model.User;
import com.dso.timex.infrastructure.adapter.out.memory.InMemoryUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TimexApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void shouldCreateAndListUsersUsingHexagonalPorts() {
		InMemoryUserRepository repository = new InMemoryUserRepository();
		UserService service = new UserService(repository);

		User created = service.createUser("test@timex.app", "Test User");

		assertNotNull(created.id());
		assertEquals("test@timex.app", created.email());
		assertEquals("Test User", created.displayName());
		assertFalse(service.listUsers().isEmpty());
	}

}
