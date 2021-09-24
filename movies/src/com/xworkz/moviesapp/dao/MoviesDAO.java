package com.xworkz.moviesapp.dao;

import java.util.List;

import com.xworkz.moviesapp.dto.MoviesDTO;

public interface MoviesDAO {
	
	boolean saveAll(List<MoviesDTO> list);


}
