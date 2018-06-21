package company.api.store.items.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

public class ItemCartTest {
	
	@Test
	public void testItemCart() {
		new BeanTester().testBean(ItemCart.class);
		new EqualsMethodTester().testEqualsMethod(ItemCart.class);
		new HashCodeMethodTester().testHashCodeMethod(ItemCart.class);
	}
	
	@Test
	public void testDefaultConstructor() {
		ItemCart cart = new ItemCart();
		assertEquals(new HashMap<Item, Integer>(), cart.getItems());
		assertEquals(0.0, cart.getTotalPrice(), .001);
	}
	
	@Test
	public void testToString() {
		String expected = "ItemCart [items={}, totalPrice=0.0]";
		assertEquals(expected, new ItemCart().toString());
	}
	
	@Test
	public void testEqualsItemsNull() {
		ItemCart cart = new ItemCart();
		cart.setItems(null);
		assertNotEquals(cart, new ItemCart());
	}
	
	@Test
	public void testEqualsPriceNull() {
		ItemCart cart = new ItemCart();
		cart.setTotalPrice(null);
		assertNotEquals(cart, new ItemCart());
	}

}
