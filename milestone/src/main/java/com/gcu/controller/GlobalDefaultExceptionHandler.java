// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

// Source: https://github.com/markreha/myprivatecloud

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
	 * @param Exception
	 * @return Model and name of the Exception View
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Error");
		model.addObject("error", "Oh no something went wrong... contact database adminstrator");
		model.setViewName("exception");
		return model;
	}
}