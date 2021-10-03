package com.DoSwipe.ProductException;

public class ProductNotFountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFountException()
	{
		super();
	}
	
	public ProductNotFountException(String message)
	{
		super(message);
	}
}
