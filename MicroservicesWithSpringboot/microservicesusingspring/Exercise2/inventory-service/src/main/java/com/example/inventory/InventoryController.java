package com.example.inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@RestController
@RequestMapping("/inventory")
public class InventoryController{
@Autowired
private InventoryRepository inventoryRepository;
@Autowired
private RestTemplate restTemplate;
@GetMapping
public List<Inventory> getAllInventory(){
return inventoryRepository.findAll();
}
@GetMapping("/{id}")
public Inventory getInventoryById(@PathVariable Long id){
return inventoryRepository.findById(id).orElse(null);
}
@GetMapping("/product/{productId}")
public InventoryWithProduct getInventoryByProductId(@PathVariable Long productId){
Inventory inventory=inventoryRepository.findByProductId(productId);
Object product=restTemplate.getForObject("http://product-service/products/"+productId,Object.class);
return new InventoryWithProduct(product,inventory);
}
@PostMapping
public Inventory createInventory(@RequestBody Inventory inventory){
return inventoryRepository.save(inventory);
}
}
