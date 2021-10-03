package com.gcu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductModel {

	//Properties 
	
	private long id; 
	
	//@NotBlank(message = "Name cannot be blank")
	//@NotNull(message = "Name is a required field")
	//@Size(max = 30, message="Name must be less than 20 characters")
	private String name;
	
	//@NotBlank(message = "Publisher cannot be blank")
	//@NotNull(message = "Publisher is a required field")
	//@Size(max = 30, message="Publisher must be less than 20 characters")
	private String publisher;
	
	//@NotBlank(message = "Genre cannot be blank")
	//@NotNull(message = "Genre is a required field")
	//@Size(max = 15, message="Name must be less than 15 characters")
	private String genre;
	
	//@NotBlank(message = "Rating cannot be blank")
	//@NotNull(message = "Rating is a required field")
	//@Size(max = 15, message="Rating must be less than 15 characters")
	private String rating;
	
	//@NotBlank(message = "Release Date cannot be blank")
	//@NotNull(message = "Release Date is a required field")
	//@Size(max = 15, message="Release Date must be less than 15 characters")
	private String releaseDate;
	
	private String image;
	
	//@NotBlank(message = "Description cannot be blank")
	//@NotNull(message = "Description is a required field")
	//@Size(max = 100, message="Description must be less than 100 characters")
	private String description;
	
	//Non-default constructor 
	public ProductModel(Long id, String name, String publiser, String genre, String
			rating, String releaseDate, String image, String description) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publiser; 
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.image = image;
		this.description = description;
	}
	

	//Getter and Setters 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	
	
}