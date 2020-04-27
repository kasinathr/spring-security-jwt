package com.community.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionAdvice {
	@ExceptionHandler(AppException.class)
	public ResponseEntity<ErrorObject> mapException(AppException exp){
		ErrorObject err =  new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(), exp.getMessage());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
