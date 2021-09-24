package com.xworkz.restaurantapp.dao;

import java.util.List;

import com.xworkz.restaurantapp.dto.RestaurantDTO;

public interface RestaurantDAO {
	
	boolean saveAll(List<RestaurantDTO> list);


}
