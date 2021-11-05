package com.gcu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefaultExceptionHandler
{
	/**
	 * Controller method to handle the unhandled Exception.
	 * 
	 * @param ex The source Exception
	 * @return Model and name of the Exception View
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		// Create a Model and View, populate with the Exception information, and display a common Error Page
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Error");
		model.addObject("error", "Oh no something went wrong... contact database adminstrator");
		model.setViewName("exception");
		return model;
	}
}