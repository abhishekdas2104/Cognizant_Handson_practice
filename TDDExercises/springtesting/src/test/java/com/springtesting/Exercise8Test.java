package com.springtesting;

import com.springtesting.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class Exercise8Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testHandleNotFoundException() throws Exception {
        when(userService.getUserById(99L)).thenThrow(new NoSuchElementException("User not found"));

        mockMvc.perform(get("/users/99"))
               .andExpect(status().isNotFound())
               .andExpect(content().string("User not found"));
    }
}
