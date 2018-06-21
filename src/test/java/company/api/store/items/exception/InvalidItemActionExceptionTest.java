package company.api.store.items.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvalidItemActionExceptionTest {
	
	@Test
	public void testInvalidItemActionException() {
		InvalidItemActionException exceptionUnderTest = new InvalidItemActionException("test message");
		assertEquals("test message", exceptionUnderTest.getMessage());
		assertEquals(InvalidItemActionException.class, exceptionUnderTest.getClass());
	}

}
