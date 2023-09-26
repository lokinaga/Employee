package com.onesoft.employee.globalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onesoft.employee.exception.AgeNotFountException;
import com.onesoft.employee.exception.NameNotFoundException;
import com.onesoft.employee.exception.SalaryNotFoundException;

@RestControllerAdvice
public class GlobalHandling {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object>NameNotFoundExpectionHandling(NameNotFoundException ne){
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> SalaryNotFoundexceptionHandling(SalaryNotFoundException se){
		return new ResponseEntity<>(se.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AgeNotFountException.class)
	public ResponseEntity<Object> AgeNotFoundhandling(AgeNotFountException ae){
		return new ResponseEntity<> (ae.getMessage(),HttpStatus.NOT_FOUND);
	}

}
