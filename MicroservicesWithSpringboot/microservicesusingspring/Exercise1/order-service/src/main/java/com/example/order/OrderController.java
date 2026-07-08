package com.example.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController{
@Autowired
private OrderRepository orderRepository;
@Autowired
private WebClient.Builder webClientBuilder;
@GetMapping
public List<Order> getAllOrders(){
return orderRepository.findAll();
}
@GetMapping("/{id}")
public Order getOrderById(@PathVariable Long id){
return orderRepository.findById(id).orElse(null);
}
@GetMapping("/user/{userId}")
public OrderWithUser getOrdersByUserId(@PathVariable Long userId){
List<Order> orders=orderRepository.findByUserId(userId);
Object user=webClientBuilder.build().get().uri("http://localhost:8081/users/"+userId).retrieve().bodyToMono(Object.class).block();
return new OrderWithUser(user,orders);
}
@PostMapping
public Order createOrder(@RequestBody Order order){
return orderRepository.save(order);
}
}
