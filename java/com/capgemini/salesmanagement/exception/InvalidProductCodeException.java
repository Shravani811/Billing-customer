package com.capgemini.salesmanagement.exception;


	public class InvalidProductCodeException extends Exception{

		public InvalidProductCodeException()
		{
			System.err.println("Product Doesn't Exist");
		}
	}

