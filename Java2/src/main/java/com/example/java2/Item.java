package com.example.java2;

public class Item implements Comparable<Item>{
private String type;
private int quantity;
private double price;
private String exdate;
public String getExdate() {
	return exdate;
}
public void setExdate(String exdate) {
	this.exdate = exdate;
}
public void setType(String type) {
	this.type = type;
}
Item(){
}
 Item(String type,String exdate){
	this.type=type;
	this.exdate=exdate;
}

public String getType() {//returns type
	return type;
}
public int getQuantity() {//returns Quantity
	return quantity;
}
public Item setQuantity(int quantity) {//sets Quantity for this instance and returns the same instance after edited
	this.quantity = quantity;
	return  this;
}
public double getPrice() {//returns price
	return price;
}
public Item setPrice(double price) {//sets price for this instance and returns the same instance after edited
	this.price = price;
	return this;
}
@Override
public int compareTo(Item o) {//comapres between two items by the price

	return	(int) (this.getPrice()-o.getPrice());
}
public Item update(int qtyIncrease) {//adds the new stock to the old stock
	this.setQuantity(this.getQuantity()+qtyIncrease);
	return this;
}
public Item update(double adjustmentFactor) {//gives the new price
	this.setPrice(this.getPrice()*(1+adjustmentFactor));
	return this;
	}
}

