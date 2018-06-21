package company.api.store.items.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import company.api.store.items.data.ItemsDAO;
import company.api.store.items.exception.InvalidItemActionException;
import company.api.store.items.model.Item;
import company.api.store.items.model.ItemCart;

@RunWith(MockitoJUnitRunner.class)
public class ItemsServiceTest {
	
	@InjectMocks
	private ItemsService serviceUnderTest;
	
	@Mock
	private ItemsDAO mockDAO;
	
	@Test
	public void testAddItem() {
		ItemCart expected = new ItemCart();
		expected.getItems().put(Item.A, 1);
		expected.setTotalPrice(1.25);	
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 1);
		
		when(mockDAO.addItem(Item.A, 1)).thenReturn(cart);
		ItemCart actual = serviceUnderTest.addItem(Item.A, 1);
		assertEquals(expected, actual);
		verify(mockDAO).addItem(Item.A, 1);
	}
	
	@Test
	public void testAddItemWithVolumeQty() {
		ItemCart expected = new ItemCart();
		expected.getItems().put(Item.A, 4);
		expected.setTotalPrice(4.25);	
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 4);
		
		when(mockDAO.addItem(Item.A, 4)).thenReturn(cart);
		ItemCart actual = serviceUnderTest.addItem(Item.A, 4);
		assertEquals(expected, actual);
		verify(mockDAO).addItem(Item.A, 4);
	}
	
	@Test
	public void testAddItemWithNoVolumePrice() {
		ItemCart expected = new ItemCart();
		expected.getItems().put(Item.B, 4);
		expected.setTotalPrice(17.0);	
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.B, 4);
		
		when(mockDAO.addItem(Item.B, 4)).thenReturn(cart);
		ItemCart actual = serviceUnderTest.addItem(Item.B, 4);
		assertEquals(expected, actual);
		verify(mockDAO).addItem(Item.B, 4);
	}
	
	@Test
	public void testRemoveItem() throws InvalidItemActionException {
		ItemCart expected = new ItemCart();
		expected.getItems().put(Item.A, 1);
		expected.setTotalPrice(1.25);	
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 1);
		
		when(mockDAO.removeItem(Item.A, 1)).thenReturn(cart);
		ItemCart actual = serviceUnderTest.removeItem(Item.A, 1);
		assertEquals(expected, actual);
		verify(mockDAO).removeItem(Item.A, 1);
	}
	
	@Test(expected = InvalidItemActionException.class)
	public void testRemoveItemThatDoesntExist() throws InvalidItemActionException {
		when(mockDAO.removeItem(Item.A, 1)).thenThrow(InvalidItemActionException.class);
		serviceUnderTest.removeItem(Item.A, 1);
		verify(mockDAO).removeItem(Item.A, 1);
	}
	
	@Test
	public void testGetCart() {
		ItemCart expected = new ItemCart();
		expected.getItems().put(Item.A, 1);
		expected.setTotalPrice(1.25);	
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 1);
		cart.setTotalPrice(1.25);
		
		when(mockDAO.getCart()).thenReturn(cart);
		ItemCart actual = serviceUnderTest.getCart();
		assertEquals(expected, actual);
		verify(mockDAO).getCart();
	}
	
	@Test
	public void testEmptyCart() {
		ItemCart expected = new ItemCart();	
		ItemCart cart = new ItemCart();
		when(mockDAO.emptyCart()).thenReturn(cart);
		ItemCart actual = serviceUnderTest.emptyCart();
		assertEquals(expected, actual);
		verify(mockDAO).emptyCart();
	}

}
