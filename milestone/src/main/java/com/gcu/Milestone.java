// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Main application entry point
 * @author anasanchez
 *
 */
@Slf4j
@SpringBootApplication
public class Milestone {
	/**
	 * Method to run program
	 * @param args (String[] args)
	 */
	public static void main(String[] args) {
		log.info("Starting application");
		SpringApplication.run(Milestone.class, args);
	}

}
