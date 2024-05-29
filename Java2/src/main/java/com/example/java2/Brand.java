package com.example.java2;

public class Brand extends Item {
private String brand;
Brand(){
	super();
}
public String getBrand() {
	return brand;
}
Brand(String brand,String type,String exdate){
	super(type,exdate);
	this.brand=brand;
}
}
