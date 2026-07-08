package com.example.inventory;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Inventory{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private Long productId;
private Integer stockLevel;
private String warehouseLocation;
public Inventory(){}
public Inventory(Long productId,Integer stockLevel,String warehouseLocation){
this.productId=productId;
this.stockLevel=stockLevel;
this.warehouseLocation=warehouseLocation;
}
public Long getId(){
return id;
}
public void setId(Long id){
this.id=id;
}
public Long getProductId(){
return productId;
}
public void setProductId(Long productId){
this.productId=productId;
}
public Integer getStockLevel(){
return stockLevel;
}
public void setStockLevel(Integer stockLevel){
this.stockLevel=stockLevel;
}
public String getWarehouseLocation(){
return warehouseLocation;
}
public void setWarehouseLocation(String warehouseLocation){
this.warehouseLocation=warehouseLocation;
}
}
