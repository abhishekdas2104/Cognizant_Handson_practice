package com.springtesting;

import com.springtesting.entity.User;
import com.springtesting.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class Exercise7Test {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Alice");

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.flush();

        List<User> result = userRepository.findByName("Alice");

        assertEquals(2, result.size());
    }
}
