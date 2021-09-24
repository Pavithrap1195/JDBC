package com.xworkz.mobiledetails;

import java.util.List;

import com.xworkz.mobiledetails.dao.MobileDetailsDAO;
import com.xworkz.mobiledetails.dao.MobileDetailsDAOImpl;
import com.xworkz.mobiledetails.dto.MobileDetailsDTO;

public class MobileTester {

	public static void main(String[] args) {

		MobileDetailsDAO dao = new MobileDetailsDAOImpl();
		MobileDetailsDTO dto = new MobileDetailsDTO();
		//dao.save(dto);
		//dao.updatePriceByName("Realme", 22000.00);
		List<MobileDetailsDTO> list = dao.getAll();
		for (MobileDetailsDTO mobileDetailsDTO : list) {
			System.out.println(mobileDetailsDTO);
		}
		System.out.println("========================================================");
		dto = dao.getByName("Realme");
		System.out.println(dto);
		
		System.out.println("==============================================================");
		List<MobileDetailsDTO> list1 = dao.getByPrice(18000.00);
		System.out.println(list1);
		
		
		
		
		
		
	}

}
