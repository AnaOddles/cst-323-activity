// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

// Source: https://github.com/markreha/myprivatecloud

package com.gcu.util;
public class ProductAlreadyExistsException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 * 
	 */
	public ProductAlreadyExistsException()
	{
		super();
	}
	
	/**
	 * Non-default constructor
	 * 
	 * @param err Wrapped exception
	 * @param errorMessage Custome excetion message
	 */
	public ProductAlreadyExistsException(Throwable err, String errorMessage)
	{
		super(errorMessage, err);
	}
}
