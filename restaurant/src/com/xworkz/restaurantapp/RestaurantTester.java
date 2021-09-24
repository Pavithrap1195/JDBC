package com.xworkz.restaurantapp;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.restaurantapp.dao.RestaurantDAO;
import com.xworkz.restaurantapp.dao.RestaurantDAOImpl;
import com.xworkz.restaurantapp.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {

		RestaurantDAO dao = new RestaurantDAOImpl();

		/*RestaurantDTO dto = new RestaurantDTO(1, "Ayodhya", "BDA Complex");
		RestaurantDTO dto1 = new RestaurantDTO(2, "Palate", "Nagarbhavi");
		RestaurantDTO dto2 = new RestaurantDTO(3, "Waterhole", "RR Nagar");
		RestaurantDTO dto3 = new RestaurantDTO(4, "BigBytes", "RR Nagar");
		RestaurantDTO dto4 = new RestaurantDTO(5, "Rajatadri", "Uttarahalli");*/
		RestaurantDTO dto5 = new RestaurantDTO(6, "Hakuna Matata", "Majestic");
		RestaurantDTO dto6 = new RestaurantDTO(7, "Kadamba", "Kengeri");

		List<RestaurantDTO> list = new ArrayList<RestaurantDTO>();
//		list.add(dto);
//		list.add(dto1);
//		list.add(dto2);
//		list.add(dto3);
//		list.add(dto4);
		list.add(dto5);
		list.add(dto6);
		boolean saved = dao.saveAll(list);
		if(saved) {
			System.out.println("Data saved");
		}else {
			System.out.println("Data not saved");
		}

	}

}
