package company.api.store.items.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

public class ResponseTest {
	
	@Test
	public void testItemCart() {
		new BeanTester().testBean(Response.class);
		new EqualsMethodTester().testEqualsMethod(Response.class);
		new HashCodeMethodTester().testHashCodeMethod(Response.class);
	}
	
	@Test
	public void testToString() {
		String expected = "Response [payload=null, errorMessage=null]";
		assertEquals(expected, new Response<String>().toString());
	}
	
	@Test
	public void testConstructors() {
		Response<Integer> expectedOne = new Response<>();
		expectedOne.setPayload(1);
		assertEquals(expectedOne, new Response<Integer>(1));
		Response<Integer> expectedTwo = new Response<>();
		expectedTwo.setErrorMessage("test");
		assertEquals(expectedTwo, new Response<Integer>("test"));
	}


}
