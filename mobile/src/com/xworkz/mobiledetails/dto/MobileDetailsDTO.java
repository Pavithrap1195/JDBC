package com.xworkz.mobiledetails.dto;

public class MobileDetailsDTO {
	
	private int mobileId;
	private String name;
	private double price;
	private String network;
	
	
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	@Override
	public String toString() {
		return "MobileDetailsDTO [mobileId=" + mobileId + ", name=" + name + ", price=" + price + ", network=" + network
				+ "]";
	}
	
	
	

}
