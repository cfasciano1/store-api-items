package company.api.store.items.data;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import company.api.store.items.ItemsApplication;
import company.api.store.items.exception.InvalidItemActionException;
import company.api.store.items.model.Item;
import company.api.store.items.model.ItemCart;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= ItemsApplication.class)
public class ItemsDAOTest {
	// I would usually have unit and int testing on the dao but mocking my fake database is painful
	// so im just going with int testing here
	@Autowired
	private ItemsDAO daoUnderTest;
	
	@Before
	public void setup() {
		daoUnderTest.emptyCart();
	}
	
	@Test
	public void testAddItem() {
		ItemCart expected = new ItemCart();
		Map<Item, Integer> expectedItems = new HashMap<>();
		expectedItems.put(Item.A, 1);
		expected.setItems(expectedItems);
		ItemCart actual = daoUnderTest.addItem(Item.A, 1);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testAddTwoOfTheSameItem() {
		ItemCart expected = new ItemCart();
		Map<Item, Integer> expectedItems = new HashMap<>();
		expectedItems.put(Item.A, 2);
		expected.setItems(expectedItems);
		daoUnderTest.addItem(Item.A, 1);
		ItemCart actual = daoUnderTest.addItem(Item.A, 1);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testRemoveItem() throws InvalidItemActionException {
		ItemCart expected = new ItemCart();
		Map<Item, Integer> expectedItems = new HashMap<>();
		expected.setItems(expectedItems);
		daoUnderTest.addItem(Item.A, 1);
		ItemCart actual = daoUnderTest.removeItem(Item.A, 1);
		assertEquals(expected, actual);	
	}
	
	@Test(expected = InvalidItemActionException.class) 
	public void testRemoveItemThatDoesntExist() throws InvalidItemActionException {
		daoUnderTest.removeItem(Item.A, 1);
	}
	
	@Test(expected = InvalidItemActionException.class) 
	public void testRemoveMoreItemsThanExists() throws InvalidItemActionException {
		daoUnderTest.addItem(Item.A, 1);
		daoUnderTest.removeItem(Item.A, 2);
	}
	
	@Test
	public void testGetCart() {
		ItemCart expected = new ItemCart();
		ItemCart actual = daoUnderTest.getCart();
		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyCart() {
		ItemCart expected = new ItemCart();
		daoUnderTest.addItem(Item.A, 1);
		daoUnderTest.addItem(Item.B, 1);
		daoUnderTest.addItem(Item.C, 1);
		daoUnderTest.addItem(Item.D, 1);
		ItemCart actual = daoUnderTest.emptyCart();
		assertEquals(expected, actual);
	}
}
