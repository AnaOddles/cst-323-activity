package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("games")
public class ProductEntity {

	@Id
	Long id;

	@Column("userId")
	Long userId;

	@Column("gameName")
	String name;

	String publisher;

	String genre;

	String rating;

	String platform;

	String image;

	String description;

	public ProductEntity(Long id, Long userId, String name, String publisher, String genre, String rating,
			String platform, String image, String description) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.platform = platform;
		this.image = image;
		this.description = description;
	}

	public ProductEntity() {

	}
	
	// GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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
