package company.api.store.items.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import company.api.store.items.data.ItemsDAO;
import company.api.store.items.exceptions.InvalidItemActionException;
import company.api.store.items.model.Item;
import company.api.store.items.model.ItemCart;

@Component
public class ItemsService {
	
	@Autowired
	ItemsDAO itemsDao;

	public ItemCart addItem(Item item, int qty) {
		ItemCart cart = itemsDao.addItem(item, qty);
		cart.setTotalPrice(calculateTotal(cart.getItems()));
		return cart;
	}
	
	public ItemCart removeItem(Item item, int qty) throws InvalidItemActionException {
		ItemCart cart = itemsDao.removeItem(item, qty);
		cart.setTotalPrice(calculateTotal(cart.getItems()));
		return cart;
	}
	
	public ItemCart emptyCart() {
		ItemCart cart = itemsDao.emptyCart();
		cart.setTotalPrice(calculateTotal(cart.getItems()));
		return cart;
	}
	
	public ItemCart getCart() {
		return itemsDao.getCart();
	}
	
	
	
	private double calculateTotal(Map<Item, Integer> items) {
		double total = 0;
		for (Map.Entry<Item, Integer> entry : items.entrySet()) {
			total += calculatePrice(entry.getKey(), entry.getValue());
		}
		return total;
	}
	private Double calculatePrice(Item item, Integer quantity) {
		if(null == item.getVolumePrice() || quantity < item.getVolumeQty()) {
			return item.getPrice() * quantity;
		}
		return ((Math.floor(quantity/item.getVolumeQty()) * item.getVolumePrice()) 
				+ (quantity % item.getVolumeQty() * item.getPrice()));
	}

}
