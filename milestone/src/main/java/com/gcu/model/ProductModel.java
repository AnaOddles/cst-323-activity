// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Object Model to capture product details
 * 
 * @author melzs
 *
 */
public class ProductModel {

	// Properties
	// @ Signals data validation rules

	/**
	 * Id of product (long)
	 */
	private long id;

	/**
	 * Name of Product (String)
	 */
	@NotBlank(message = "Name cannot be blank")
	@NotNull()
	@Size(max = 30, message = "Name must be less than 20 characters")
	private String name;

	/**
	 * Publisher of Product (String)
	 */
	@NotBlank(message = "Publisher cannot be blank")
	@NotNull()
	@Size(max = 30, message = "Publisher must be less than 20 characters")
	private String publisher;

	/**
	 * Genre of Product (String)
	 */
	@NotBlank(message = "Genre cannot be blank")
	@NotNull()
	@Size(max = 15, message = "Name must be less than 15 characters")
	private String genre;

	/**
	 * Rating of Product (String)
	 */
	@NotBlank(message = "Rating cannot be blank")
	@NotNull()
	@Size(max = 15, message = "Rating must be less than 15 characters")
	private String rating;

	/**
	 * Release Date of Product (String)
	 */
	@NotBlank(message = "Release Date cannot be blank")
	@NotNull()
	@Size(max = 15, message = "Release Date must be less than 15 characters")
	private String releaseDate;

	/**
	 * Image (URL) of Product (String)
	 */
	@NotBlank(message = "Image cannot be blank")
	@NotNull
	private String image;

	/**
	 * Description of product (String)
	 */
	@NotBlank(message = "Description cannot be blank")
	@NotNull()
	@Size(max = 150, message = "Description must be less than 150 characters")
	private String description;

	// Non-default constructor
	/**
	 * Constructor with properties
	 * 
	 * @param id
	 * @param name
	 * @param publiser
	 * @param genre
	 * @param rating
	 * @param releaseDate
	 * @param image
	 * @param description
	 */
	public ProductModel(Long id, String name, String publiser, String genre, String rating, String releaseDate,
			String image, String description) {
		this.id = id;
		this.name = name;
		this.publisher = publiser;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.image = image;
		this.description = description;
	}

	// Default Constructor
	/**
	 * Default Constructor
	 */
	public ProductModel() {

	}

	// GETTERS AND SETTERS
	/**
	 * Access to product Id
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * Access to set product Id
	 * 
	 * @param id (long)
	 */
	public void setId(long id) {
		this.id = id;
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
	 * Access to product release date
	 * 
	 * @return releaseDate (string)
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Access to set product release date
	 * 
	 * @param releaseDate
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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
	 * @return string interpretation of ProductModel (string)
	 */
	@Override
	public String toString() {
		return "ProductModel:\n id: " + id + ",\n name: " + name + ",\n publisher: " + publisher + ",\n genre: " + genre
				+ ",\n rating: " + rating + ",\n releaseDate: " + releaseDate + ",\n image: " + image
				+ ",\n description: " + description;
	}

}
