package com.xworkz.moviesapp;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.moviesapp.dao.MoviesDAO;
import com.xworkz.moviesapp.dao.MoviesDAOImpl;
import com.xworkz.moviesapp.dto.MoviesDTO;

public class MovieTester {
	
	public static void main(String[] args) {
		
		MoviesDAO dao = new MoviesDAOImpl();
		/*MoviesDTO dto = new MoviesDTO(1,"Love Mocktail","Krishna");
		MoviesDTO dto1 = new MoviesDTO(2,"RajKumaara","PuneethRajkumar");
		MoviesDTO dto2 = new MoviesDTO(3,"Sparsha","Sudeep");
		MoviesDTO dto3 = new MoviesDTO(4,"99","Ganesh");
		MoviesDTO dto4 = new MoviesDTO(5,"Vishwasam","AjithKumar");*/
		MoviesDTO dto5 = new MoviesDTO(6,"Nalla","Sudeep");
		MoviesDTO dto6 = null;
		
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		/*list.add(dto);
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		list.add(dto4);*/
		list.add(dto5);
		list.add(dto6);
		boolean  saved = dao.saveAll(list);
		if(saved) {
			System.out.println("Data Saved");
		}else {
			System.out.println("Data not saved");
		}
		
		
	}

}
