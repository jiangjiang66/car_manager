package com.domain;

import java.util.Date;

public class Car {
	private int carid;
	private String color;
	private String type;
	private String size;
	private String name;
	private Date borthday;
	private int maintain;
	private int price;
	
	public Car() {
		super();
	}
	

	@Override
	public String toString() {
		return "Car [carid=" + carid + ", color=" + color + ", type=" + type + ", size=" + size + ", name=" + name
				+ ", borthday=" + borthday + ", maintain=" + maintain + ", price=" + price + "]";
	}


	public Car(int carid, String color, String type, String size, String name, Date borthday, int maintain, int price) {
		super();
		this.carid = carid;
		this.color = color;
		this.type = type;
		this.size = size;
		this.name = name;
		this.borthday = borthday;
		this.maintain = maintain;
		this.price = price;
	}


	public Car(String color, String type, String size, String name, Date borthday, int maintain, int price) {
		super();
		this.color = color;
		this.type = type;
		this.size = size;
		this.name = name;
		this.borthday = borthday;
		this.maintain = maintain;
		this.price = price;
	}

	public int getCarid() {
		return carid;
	}
	
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBorthday() {
		return borthday;
	}
	public void setBorthday(Date borthday) {
		this.borthday = borthday;
	}
	public int getMaintain() {
		return maintain;
	}
	public void setMaintain(int maintain) {
		this.maintain = maintain;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
