package com.addressservice.exceptionHandlers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressRequestBodyValidation {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,Object> validateAddressRequestBody(MethodArgumentNotValidException ex)
	{
		Map<String,Object> resultMap = new HashMap<>();
		Map<String,String> innerMap = new HashMap<>();
		resultMap.put("statusCode","400");
		
		ex.getBindingResult()
		    .getFieldErrors()
		       .stream()
		          .map((result)->{
		        	  innerMap.put(result.getField(),result.getDefaultMessage());
		        	 return innerMap;
		          }).collect(Collectors.toList());
		resultMap.put("errorMessage", innerMap);
		  return resultMap;  
	}
	
	
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ExceptionHandler(HttpMessageNotReadableException.class)
   public Map<String,String> handleMessageNotRedableException(HttpMessageNotReadableException ex){
	   	  
	   Map<String, String> resultMap = new HashMap<>();
	   resultMap.put("statusCode","400");
	   resultMap.put("errorMessage",ex.getMessage());
	   return resultMap;
   }
}
