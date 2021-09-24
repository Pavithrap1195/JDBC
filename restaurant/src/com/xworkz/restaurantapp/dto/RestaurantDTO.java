package com.xworkz.restaurantapp.dto;

public class RestaurantDTO {
	
	private int restaurantId;
	private String name;
	private String location;
	
	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RestaurantDTO(int restaurantId, String name, String location) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.location = location;
	}



	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [restaurantId=" + restaurantId + ", name=" + name + ", location=" + location + "]";
	}
	
	

}
