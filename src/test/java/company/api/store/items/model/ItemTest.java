package company.api.store.items.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
	
	
	@Test
	public void testValueOf() {
		assertEquals(Item.A, Item.valueOf("A"));
		assertEquals(Item.B, Item.valueOf("B"));
		assertEquals(Item.C, Item.valueOf("C"));
		assertEquals(Item.D, Item.valueOf("D"));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testValueOfBadValue() {
		Item.valueOf("Z");
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(1.25, Item.A.getPrice(), .001);
		assertEquals(4.25, Item.B.getPrice(), .001);
		assertEquals(1.0, Item.C.getPrice(), .001);
		assertEquals(.75, Item.D.getPrice(), .001);
	}
	
	@Test
	public void testGetVolumePrice() {
		assertEquals(3.0, Item.A.getVolumePrice(), .001);
		assertEquals(null, Item.B.getVolumePrice());
		assertEquals(5.0, Item.C.getVolumePrice(), .001);
		assertEquals(null, Item.D.getVolumePrice());
	}
	
	@Test
	public void testGetVolumeQty() {
		assertEquals(3, Item.A.getVolumeQty().intValue());
		assertEquals(null, Item.B.getVolumeQty());
		assertEquals(6, Item.C.getVolumeQty().intValue());
		assertEquals(null, Item.D.getVolumeQty());
	}


}
