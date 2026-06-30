package com.springtesting;

import com.springtesting.repository.UserRepository;
import com.springtesting.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Exercise6Test {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testUserNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getUserOrThrow(99L));
    }
}
