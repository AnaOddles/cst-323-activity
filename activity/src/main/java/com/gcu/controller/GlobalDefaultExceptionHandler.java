// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

// Source: https://github.com/markreha/myprivatecloud

package com.gcu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// Annotation for ControllerAdvice
@ControllerAdvice
public class GlobalDefaultExceptionHandler
{
	/**
	 * Controller method to handle the unhandled Exception.
	 * 
	 * @param Exception
	 * @return Model and name of the Exception View
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		//Create a model and view obj
		ModelAndView model = new ModelAndView();
		
		//Modify the title and error attributes on view
		model.addObject("title", "Error");
		model.addObject("error", "Oh no something went wrong... contact database adminstrator");
		
		//Set the view to exception.html
		model.setViewName("exception");
		return model;
	}
}