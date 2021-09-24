package com.xworkz.fruitsapp;

import java.util.List;

import com.xworkz.fruitsapp.dao.FruitsDAO;
import com.xworkz.fruitsapp.dao.FruitsDAOImpl;
import com.xworkz.fruitsapp.dto.FruitsDTO;

public class FruitsTester {

	public static void main(String[] args) {

		FruitsDAO dao = new FruitsDAOImpl();
		FruitsDTO dto = new FruitsDTO();
		// dao.save(dto);
		// dao.updatePriceByName("Mango", 150.00);
		List<FruitsDTO> list = dao.getAll();
		for (FruitsDTO fruitsDTO : list) {
			System.out.println(fruitsDTO);
		}
		System.out.println("===================================================");
		dto = dao.getByName("Apple");
		System.out.println(dto);

		System.out.println("===================================================");
		List<FruitsDTO> fruit = dao.getByPrice(150.00);
		System.out.println(fruit);
	}

}
