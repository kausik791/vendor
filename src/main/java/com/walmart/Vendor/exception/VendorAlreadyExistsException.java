package com.walmart.Vendor.exception;

public class VendorAlreadyExistsException extends Exception {

	public VendorAlreadyExistsException() {
		super();
		
	}

	public VendorAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public VendorAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public VendorAlreadyExistsException(String message) {
		super(message);
		
	}

	public VendorAlreadyExistsException(Throwable cause) {
		super(cause);
		
	}
	
	

}
