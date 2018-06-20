package company.api.store.items.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import company.api.store.items.exceptions.InvalidItemActionException;
import company.api.store.items.model.Response;

@ControllerAdvice
public class ItemsControllerAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsControllerAdvice.class);

	@ExceptionHandler(InvalidItemActionException.class)
	public ResponseEntity<Response<Void>> handleInvalidItemActionException(InvalidItemActionException exception){
		LOGGER.error(exception.getMessage());
		return new ResponseEntity<>(new Response<Void>(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConversionFailedException.class)
	public ResponseEntity<Response<Void>> handleIllegalArgumentException(ConversionFailedException exception){
		LOGGER.error(exception.getMessage());
		return new ResponseEntity<>(new Response<Void>("Scan failed. Not a valid item."), HttpStatus.BAD_REQUEST);
	}
	
	
	
}
