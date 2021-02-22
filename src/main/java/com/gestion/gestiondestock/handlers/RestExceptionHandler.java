package com.gestion.gestiondestock.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.InvalidEntityException;

@RestControllerAdvice
//fama @ControllerAdvice ama he4i khir
//@RestControllerAdvice  t5lik mch lezm kol methode t3mllha @responseBody 

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)

	// lorsque j'annote cette methode comme ca lorsque cette exception
	// EntityNotFoundException
	// est thrown elle sera capté par cette methode et on vas alors executer cette
	// methode

	public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErrorDto errorDto = ErrorDto.builder().codeErreur(exception.getErrorCode()).httpCode(notFound.value())
				.message(exception.getMessage()).build();
		return new ResponseEntity<>(errorDto, notFound);
	}

	@ExceptionHandler(InvalidEntityException.class)

	public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		final ErrorDto errorDto = ErrorDto.builder().codeErreur(exception.getErrorCode()).httpCode(badRequest.value())
				.message(exception.getMessage()).errors(exception.getErrors()).build();
		return new ResponseEntity<>(errorDto, badRequest);
	}
	
	
	/*
	 * on ne veut pas avoir de null pointer exception... mch l app t3ml erreuret kima t7b
	 * a7na n3mlou l erreuret pour securisé l'application de tout exceptions l ynjmou ysirou*/
}
