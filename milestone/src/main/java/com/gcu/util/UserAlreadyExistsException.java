package com.gcu.util;
public class UserAlreadyExistsException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 * 
	 */
	public UserAlreadyExistsException()
	{
		super();
	}
	
	/**
	 * Non-default constructor
	 * 
	 * @param err Wrapped exception
	 * @param errorMessage Custome excetion message
	 */
	public UserAlreadyExistsException(Throwable err, String errorMessage)
	{
		super(errorMessage, err);
	}
}
