package company.api.store.items.model;

public enum Item {
A(1.25, 3.0, 3),
B(4.25, null, null),
C(1.0, 5.0, 6),
D(.75, null, null);
	
	private Double price;
	private Double volumePrice;
	private Integer volumeQty;
	
	Item(Double price, Double volumePrice, Integer volumeQty){
		this.price = price;
		this.volumePrice = volumePrice;
		this.volumeQty = volumeQty;
	}

	public Double getPrice() {
		return price;
	}

	public Double getVolumePrice() {
		return volumePrice;
	}

	public Integer getVolumeQty() {
		return volumeQty;
	}
}
