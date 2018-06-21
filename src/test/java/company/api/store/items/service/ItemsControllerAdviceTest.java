package company.api.store.items.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import company.api.store.items.exception.InvalidItemActionException;
import company.api.store.items.model.Response;

public class ItemsControllerAdviceTest {
	
	private ItemsControllerAdvice adviceUnderTest;
	
	@Before
	public void setup() {
		adviceUnderTest = new ItemsControllerAdvice();
	}
	
	@Test
	public void testHandleInvalidItemActionException() {
		ResponseEntity<Response<Void>> expected = new ResponseEntity<>(new Response<Void>("test"), HttpStatus.BAD_REQUEST);
		ResponseEntity<Response<Void>> actual = adviceUnderTest.handleInvalidItemActionException(new InvalidItemActionException("test"));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHandleConversionFailedException() {
		ResponseEntity<Response<Void>> expected = new ResponseEntity<>(new Response<Void>("Scan failed. Not a valid item."), HttpStatus.BAD_REQUEST);
		ResponseEntity<Response<Void>> actual = adviceUnderTest.handleConversionFailedException(new ConversionFailedException(null,null,null,null));
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHandleUncaughtException() {
		ResponseEntity<Response<Void>> expected = new ResponseEntity<>(new Response<Void>("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		ResponseEntity<Response<Void>> actual = adviceUnderTest.handleUncaughtException(new Exception());
		assertEquals(expected, actual);
	}

}
