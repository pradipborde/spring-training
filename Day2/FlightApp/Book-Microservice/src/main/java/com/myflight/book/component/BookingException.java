package com.myflight.book.component;

public class BookingException extends RuntimeException  {
	
	private static final long serialVersionUID = 3456356731681800279L;

	public BookingException(String message){
		super(message);
	}
}
