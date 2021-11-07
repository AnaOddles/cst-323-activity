// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("games")
public class ProductEntity {

	@Id
	@Column("game_Id")
	Long productId;

	@Column("user_Id")
	Long userId;

	@Column("name")
	String name;

	String publisher;

	String genre;

	String rating;

	String platform;

	String image;

	String description;
	
	public ProductEntity(Long userId, String name, String publisher, String genre, String rating,
			String platform, String image, String description) {
		this.userId = userId;
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.platform = platform;
		this.image = image;
		this.description = description;
	}

	public ProductEntity(Long productId, Long userId, String name, String publisher, String genre, String rating,
			String platform, String image, String description) {
		this.productId = productId;
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
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "ProductEntity:\n productId: " + productId + ",\n userId: " + userId + ",\n name: " + name + ",\n publisher: "
				+ publisher + ",\n genre: " + genre + ",\n rating: " + rating + ",\n platform: " + platform
				+ ",\n image: " + image + ",\n description: " + description;
	}
	
	


}
