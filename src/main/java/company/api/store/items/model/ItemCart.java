package company.api.store.items.model;

import java.util.HashMap;
import java.util.Map;

public class ItemCart {
	
	private Map<Item, Integer> items;
	private Double totalPrice;
	
	public ItemCart () {
		items = new HashMap<>();
		totalPrice = 0.0;
	}
	
	public Map<Item, Integer> getItems() {
		return items;
	}
	public void setItems(Map<Item, Integer> items) {
		this.items = items;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}