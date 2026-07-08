package com.example.inventory;
public class InventoryWithProduct{
private Object product;
private Inventory inventory;
public InventoryWithProduct(){}
public InventoryWithProduct(Object product,Inventory inventory){
this.product=product;
this.inventory=inventory;
}
public Object getProduct(){
return product;
}
public void setProduct(Object product){
this.product=product;
}
public Inventory getInventory(){
return inventory;
}
public void setInventory(Inventory inventory){
this.inventory=inventory;
}
}
