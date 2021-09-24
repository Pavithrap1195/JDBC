package com.xworkz.gun.dao;

import java.util.List;

import com.xworkz.gun.dto.GunDetailsDTO;

public interface GunDetailsDAO {
	
	List<GunDetailsDTO> getAll();
	
	boolean saveAll(List<GunDetailsDTO> list);
	
	GunDetailsDTO getByModel(String model);
	
	//boolean updatePriceByModel(String model, int price);
	
	List<GunDetailsDTO> getByPrice(int price);


}
