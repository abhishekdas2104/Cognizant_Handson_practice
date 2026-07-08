package com.example.billing;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Billing{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private Long customerId;
private Double amount;
private String status;
public Billing(){}
public Billing(Long customerId,Double amount,String status){
this.customerId=customerId;
this.amount=amount;
this.status=status;
}
public Long getId(){
return id;
}
public void setId(Long id){
this.id=id;
}
public Long getCustomerId(){
return customerId;
}
public void setCustomerId(Long customerId){
this.customerId=customerId;
}
public Double getAmount(){
return amount;
}
public void setAmount(Double amount){
this.amount=amount;
}
public String getStatus(){
return status;
}
public void setStatus(String status){
this.status=status;
}
}
