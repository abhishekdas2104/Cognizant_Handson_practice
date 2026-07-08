package com.example.order;
import java.util.List;
public class OrderWithUser{
private Object user;
private List<Order> orders;
public OrderWithUser(){}
public OrderWithUser(Object user,List<Order> orders){
this.user=user;
this.orders=orders;
}
public Object getUser(){
return user;
}
public void setUser(Object user){
this.user=user;
}
public List<Order> getOrders(){
return orders;
}
public void setOrders(List<Order> orders){
this.orders=orders;
}
}
