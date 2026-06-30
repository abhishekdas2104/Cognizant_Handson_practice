package com.springtesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springtesting.entity.User;
import com.springtesting.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class Exercise5Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Charlie");

        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(user)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Charlie"));
    }
}
