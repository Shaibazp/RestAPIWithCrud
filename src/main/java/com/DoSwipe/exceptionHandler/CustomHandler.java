package com.DoSwipe.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.DoSwipe.ProductException.ProductNotFountException;



@RestControllerAdvice
public class CustomHandler {
	
//	@ExceptionHandler(ProductNotFountException.class)
//	public ResponseEntity<String> CustomeException(ProductNotFountException pnf)
//	{
//		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(ProductNotFountException.class)
	public ResponseEntity<ErrorMessage> CustomeException(ProductNotFountException pnf)
	{
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(pnf.getMessage(),"Product", new Date().toString(),"Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
