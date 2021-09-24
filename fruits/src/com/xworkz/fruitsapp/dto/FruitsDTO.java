package com.xworkz.fruitsapp.dto;

public class FruitsDTO {
	
	private int fruitId;
	private String name;
	private double pricePerKg;
	
	
	public int getFruitId() {
		return fruitId;
	}
	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPricePerKg() {
		return pricePerKg;
	}
	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	@Override
	public String toString() {
		return "FruitsDTO [fruitId=" + fruitId + ", name=" + name + ", pricePerKg=" + pricePerKg + "]";
	}
	
	

}
