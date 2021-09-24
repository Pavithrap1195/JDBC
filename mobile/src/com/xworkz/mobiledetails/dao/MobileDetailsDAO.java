package com.xworkz.mobiledetails.dao;

import java.util.List;

import com.xworkz.mobiledetails.dto.MobileDetailsDTO;

public interface MobileDetailsDAO {

	boolean save(MobileDetailsDTO dto);

	boolean updatePriceByName(String name, double price);

	List<MobileDetailsDTO> getAll();

	MobileDetailsDTO getByName(String name);

	List<MobileDetailsDTO> getByPrice(double price);

}
