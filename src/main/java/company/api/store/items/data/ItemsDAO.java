package company.api.store.items.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import company.api.store.items.exceptions.InvalidItemActionException;
import company.api.store.items.model.Item;
import company.api.store.items.model.ItemCart;

@Component
public class ItemsDAO {
	
	@Autowired
	private ItemCart cart;
	
	
	public ItemCart addItem(Item item, int qty) {
		if(null == cart.getItems().get(item)) {
			cart.getItems().put(item, qty);
		}else {
		cart.getItems().replace(item, (cart.getItems().get(item) + qty));
		}
		return cart;
	}	
	
	public ItemCart removeItem(Item item, int qty) throws InvalidItemActionException {
		if(null == cart.getItems().get(item) || cart.getItems().get(item) < qty ) {
			throw new InvalidItemActionException("Cannot remove an item that's not in your cart.");
		}
		cart.getItems().replace(item, (cart.getItems().get(item) - qty));
		if (0 == cart.getItems().get(item)) {
			cart.getItems().remove(item);
		}
		return cart;
	}
	
	public ItemCart emptyCart() {
		cart.getItems().clear();
		return cart;
	}
	
	public ItemCart getCart() {
		return cart;
	}
	

}
