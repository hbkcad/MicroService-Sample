package com.movie.model;

public class CatalogueItems {

	private String desc;
	private String name;
	private int rating;
	
	
	public CatalogueItems(String title, String name, int rating) {
		super();
		this.desc = title;
		this.name = name;
		this.rating = rating;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String title) {
		this.desc = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
