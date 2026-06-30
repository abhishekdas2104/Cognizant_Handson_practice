package com.springtesting.service;

import com.springtesting.entity.User;
import com.springtesting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
