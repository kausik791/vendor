package com.walmart.Vendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {

	}
	
	@ExceptionHandler
	public ResponseEntity<VendorErrorResponse> vendorNotFoundException(VendorNotFoundException exception){
		
		VendorErrorResponse error=new VendorErrorResponse(
				                HttpStatus.NOT_FOUND.value(),
				                exception.getMessage(),
				                System.currentTimeMillis()
				                );
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
    public ResponseEntity<VendorErrorResponse> VendorAlreadyExistsException(VendorAlreadyExistsException exception){
		
		VendorErrorResponse error=new VendorErrorResponse(
				                HttpStatus.CONFLICT.value(),
				                exception.getMessage(),
				                System.currentTimeMillis()
				                );
		return new ResponseEntity<>(error,HttpStatus.CONFLICT);
		
	}
    
	@ExceptionHandler
    ResponseEntity<VendorErrorResponse> globalException(Exception exception){
		
		VendorErrorResponse error=new VendorErrorResponse(
				                HttpStatus.BAD_REQUEST.value(),
				                exception.getMessage(),
				                System.currentTimeMillis()
				                );
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}


