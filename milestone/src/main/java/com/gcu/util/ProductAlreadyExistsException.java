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
