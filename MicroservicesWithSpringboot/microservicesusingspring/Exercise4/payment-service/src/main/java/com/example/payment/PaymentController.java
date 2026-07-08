package com.example.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/payments")
public class PaymentController{
@Autowired
private PaymentService paymentService;
@GetMapping("/process/{orderId}")
public String processPayment(@PathVariable String orderId){
return paymentService.processPayment(orderId);
}
}
