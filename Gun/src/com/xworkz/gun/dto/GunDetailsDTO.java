package com.xworkz.gun.dto;

public class GunDetailsDTO {
	
	private int gun_id;
	private String gun_model;
	private int gun_price;
	
	public GunDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GunDetailsDTO(int gun_id, String gun_model, int gun_price) {
		this.gun_id = gun_id;
		this.gun_model = gun_model;
		this.gun_price = gun_price;
	}



	public int getGun_id() {
		return gun_id;
	}

	public void setGun_id(int gun_id) {
		this.gun_id = gun_id;
	}

	public String getGun_model() {
		return gun_model;
	}

	public void setGun_model(String gun_model) {
		this.gun_model = gun_model;
	}

	public int getGun_price() {
		return gun_price;
	}

	public void setGun_price(int gun_price) {
		this.gun_price = gun_price;
	}

	@Override
	public String toString() {
		return "GunDetailsDTO [gun_id=" + gun_id + ", gun_model=" + gun_model + ", gun_price=" + gun_price + "]";
	}
	
	
	
	
	

}
