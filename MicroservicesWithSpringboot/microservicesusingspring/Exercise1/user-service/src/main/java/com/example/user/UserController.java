package com.example.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController{
@Autowired
private UserRepository userRepository;
@GetMapping
public List<User> getAllUsers(){
return userRepository.findAll();
}
@GetMapping("/{id}")
public User getUserById(@PathVariable Long id){
return userRepository.findById(id).orElse(null);
}
@PostMapping
public User createUser(@RequestBody User user){
return userRepository.save(user);
}
}
