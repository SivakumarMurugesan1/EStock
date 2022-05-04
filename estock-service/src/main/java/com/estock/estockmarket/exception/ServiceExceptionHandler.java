package com.estock.estockmarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class ServiceExceptionHandler {
	
	 @ExceptionHandler({CompanyNotCreatedException.class})
	    public ResponseEntity<Object> handleControllerExceptionNotCreated(Exception ex,WebRequest request) {	                                                                                      
	        ExceptionResponse exceptionresponse=new ExceptionResponse(ex.getMessage());
	        return new ResponseEntity<>(exceptionresponse,HttpStatus.CONFLICT);
	    }
    
	 @ExceptionHandler({CompanyNotFoundException.class})
	    public ResponseEntity<Object> handleControllerExceptionNotFound(Exception ex,WebRequest request) {	                                                                                      
		    ExceptionResponse exceptionresponse=new ExceptionResponse(ex.getMessage());
	        return new ResponseEntity<>(exceptionresponse,HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler({ Exception.class })
	    public ResponseEntity<Object> handleGenericException(Exception ex,WebRequest request){	                                                                                      
		 	ExceptionResponse exceptionresponse=new ExceptionResponse(ex.getMessage());
	        return new ResponseEntity<>(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
