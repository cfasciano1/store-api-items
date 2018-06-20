package company.api.store.items.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import company.api.store.items.model.ItemCart;

@Configuration
public class DataConfig {
	
	@Bean
	public ItemCart itemCart() {
		ItemCart cart = new ItemCart();
		return cart;
	}
	
}
