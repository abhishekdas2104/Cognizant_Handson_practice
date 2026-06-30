package com.springtesting;

import com.springtesting.entity.User;
import com.springtesting.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Exercise4Test {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testFullFlow() {
        User user = new User();
        user.setId(10L);
        user.setName("Bob");
        userRepository.save(user);

        ResponseEntity<User> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/users/10", User.class);

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Bob", response.getBody().getName());
    }
}
