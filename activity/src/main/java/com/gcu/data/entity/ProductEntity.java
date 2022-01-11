// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Object Entity to Capture Product details
 * 
 * @author melzs
 *
 */
// Table for entities
@Table("games")
public class ProductEntity {

	/**
	 * Id of product (long)
	 */
	@Id
	@Column("game_Id")
	Long productId;
	/*
	 * Name of Product (String)
	 */
	@Column("name")
	String name;
	/**
	 * Publisher of Product (String)
	 */
	String publisher;

	/**
	 * Genre of Product (String)
	 */
	String genre;

	/**
	 * Rating of Product (String)
	 */
	String rating;
	/**
	 * Platform of Product (String)
	 */
	String platform;
	/**
	 * Image (URL) of Product (String)
	 */
	String image;
	/**
	 * Description of product (String)
	 */
	String description;
	
	/**
	 * Constructor with Parameters no PK
	 * @param name
	 * @param publisher
	 * @param genre
	 * @param rating
	 * @param platform
	 * @param image
	 * @param description
	 */
	public ProductEntity(String name, String publisher, String genre, String rating, String platform,
			String image, String description) {
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.platform = platform;
		this.image = image;
		this.description = description;
	}
	
	/**
	 * Constructor with Parameters
	 * @param productId
	 * @param userId
	 * @param name
	 * @param publisher
	 * @param genre
	 * @param rating
	 * @param platform
	 * @param image
	 * @param description
	 */
	public ProductEntity(Long productId, String name, String publisher, String genre, String rating,
			String platform, String image, String description) {
		this.productId = productId;
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.rating = rating;
		this.platform = platform;
		this.image = image;
		this.description = description;
	}
	
	/**
	 * Default Constructor
	 */
	public ProductEntity() {

	}

	// GETTERS AND SETTERS
	/**
	 * Access to product Id
	 * 
	 * @return long
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * Access to set product Id
	 * 
	 * @param id (long)
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * Access to product name
	 * 
	 * @return name (string)
	 */
	public String getName() {
		return name;
	}
	/**
	 * Access to set product name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Access to product publisher
	 * 
	 * @return publisher (string)
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * Access to set product publisher
	 * 
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * Access to product genre
	 * 
	 * @return genre (string)
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * Access to set product genre
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * Access to product rating
	 * 
	 * @return rating (string)
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * Access to set product rating
	 * 
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * Access to product platform
	 * 
	 * @return platform (string)
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * Access to set product platform
	 * 
	 * @param platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * Access to product image
	 * 
	 * @return image (string)
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Access to set product image
	 * 
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * Access to product description
	 * 
	 * @return description (string)
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Access to set product description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return string interpretaction of Product Entity (string)
	 */
	@Override
	public String toString() {
		return "ProductEntity:\n productId: " + productId + ",\n userId: " + ",\n name: " + name
				+ ",\n publisher: " + publisher + ",\n genre: " + genre + ",\n rating: " + rating + ",\n platform: "
				+ platform + ",\n image: " + image + ",\n description: " + description;
	}

}
