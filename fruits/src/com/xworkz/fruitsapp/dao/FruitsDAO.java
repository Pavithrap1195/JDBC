package com.xworkz.fruitsapp.dao;

import java.util.List;

import com.xworkz.fruitsapp.dto.FruitsDTO;

public interface FruitsDAO {
	
	boolean save(FruitsDTO dto);

	boolean updatePriceByName(String name, double price);

	List<FruitsDTO> getAll();

	FruitsDTO getByName(String name);

	List<FruitsDTO> getByPrice(double price);


}
