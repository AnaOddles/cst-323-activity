// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

// Source: https://github.com/markreha/myprivatecloud

package com.gcu.util;
public class InvalidCredentialsException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 * 
	 */
	public InvalidCredentialsException()
	{
		super();
	}
	
	/**
	 * Non-default constructor
	 * 
	 * @param err Wrapped exception
	 * @param errorMessage Custom exception message
	 */
	public InvalidCredentialsException(Throwable err, String errorMessage)
	{
		super(errorMessage, err);
	}
}
