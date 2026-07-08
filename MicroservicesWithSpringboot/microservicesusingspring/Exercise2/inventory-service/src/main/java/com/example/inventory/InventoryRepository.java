package com.example.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
Inventory findByProductId(Long productId);
}
