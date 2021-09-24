package com.xworkz.gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.xworkz.gun.dao.GunDetailsDAO;
import com.xworkz.gun.dao.GunDetailsDAOImpl;
import com.xworkz.gun.dto.GunDetailsDTO;

public class GunTester {
	
	public static void main(String[] args) {
		
		GunDetailsDAO dao = new GunDetailsDAOImpl();
		/*List<GunDetailsDTO> list = dao.getAll();
		for (GunDetailsDTO gunDetailsDTO : list) {
			System.out.println(gunDetailsDTO);
		}
		
				
		GunDetailsDTO gun = dao.getByModel("AWM");
		System.out.println(gun);
		
		
		
		List<GunDetailsDTO> list1 = dao.getByPrice(3000000);
		System.out.println(list1);
		*/
		GunDetailsDTO dto = new GunDetailsDTO(10,"Pistol",35000);
		GunDetailsDTO dto2 = new GunDetailsDTO(11,"Riffle",55000);
		GunDetailsDTO dto3 = new GunDetailsDTO(12,"UZI",65000);
		List<GunDetailsDTO> list2 = new ArrayList<GunDetailsDTO>();
		list2.add(dto);
		list2.add(dto2);
		list2.add(dto3);
		
		boolean saved = dao.saveAll(list2);
		if(saved) {
			System.out.println("Saved");
		}else {
			System.out.println("Not saved");
		}
	}

}
