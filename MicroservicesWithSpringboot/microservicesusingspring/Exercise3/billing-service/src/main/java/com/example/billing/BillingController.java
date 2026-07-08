package com.example.billing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/billing")
public class BillingController{
@Autowired
private BillingRepository billingRepository;
@GetMapping
public List<Billing> getAllBills(){
return billingRepository.findAll();
}
@GetMapping("/{id}")
public Billing getBillById(@PathVariable Long id){
return billingRepository.findById(id).orElse(null);
}
@PostMapping
public Billing createBill(@RequestBody Billing billing){
return billingRepository.save(billing);
}
}
