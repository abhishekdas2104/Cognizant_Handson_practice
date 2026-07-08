package com.example.order;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="orders")
public class Order{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private Long userId;
private String productName;
private Integer quantity;
private Double totalPrice;
public Order(){}
public Order(Long userId,String productName,Integer quantity,Double totalPrice){
this.userId=userId;
this.productName=productName;
this.quantity=quantity;
this.totalPrice=totalPrice;
}
public Long getId(){
return id;
}
public void setId(Long id){
this.id=id;
}
public Long getUserId(){
return userId;
}
public void setUserId(Long userId){
this.userId=userId;
}
public String getProductName(){
return productName;
}
public void setProductName(String productName){
this.productName=productName;
}
public Integer getQuantity(){
return quantity;
}
public void setQuantity(Integer quantity){
this.quantity=quantity;
}
public Double getTotalPrice(){
return totalPrice;
}
public void setTotalPrice(Double totalPrice){
this.totalPrice=totalPrice;
}
}
