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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCart other = (ItemCart) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCart [items=" + items + ", totalPrice=" + totalPrice + "]";
	}
	
}