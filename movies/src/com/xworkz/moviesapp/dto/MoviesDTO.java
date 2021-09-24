package com.xworkz.moviesapp.dto;

public class MoviesDTO {
	
	private int moviesId;
	private String name;
	private String actor;
	
	public MoviesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MoviesDTO(int moviesId, String name, String actor) {
		this.moviesId = moviesId;
		this.name = name;
		this.actor = actor;
	}

	public int getMoviesId() {
		return moviesId;
	}

	public void setMoviesId(int moviesId) {
		this.moviesId = moviesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "MoviesDTO [moviesId=" + moviesId + ", name=" + name + ", actor=" + actor + "]";
	}
	
	

}
