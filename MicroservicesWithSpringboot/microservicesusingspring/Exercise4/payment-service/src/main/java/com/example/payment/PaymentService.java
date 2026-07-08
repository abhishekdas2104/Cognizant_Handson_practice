package com.example.payment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import java.util.Random;
@Service
public class PaymentService{
private Random random=new Random();
@CircuitBreaker(name="paymentCircuitBreaker",fallbackMethod="fallbackPayment")
public String processPayment(String orderId){
if(random.nextInt(10)<5){
throw new RuntimeException("External API failed");
}
return "Payment processed successfully for order: "+orderId;
}
public String fallbackPayment(String orderId,Exception e){
System.out.println("Circuit breaker activated! Fallback method called. Error: "+e.getMessage());
return "Payment processing failed. Please try again later. Order: "+orderId;
}
}
