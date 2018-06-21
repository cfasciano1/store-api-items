package company.api.store.items.bdd;

import static org.junit.Assert.assertEquals;

import org.springframework.http.MediaType;

import company.api.store.items.model.ItemCart;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ItemsAcceptanceBDDSteps {
	
	private String[] items;
	
	private RequestSpecification request;
	
	private Response response;
	
	private static final String ADD_REMOVE_ITEM_URL = "/api/store/item/";
	private static final String GET_EMPTY_CART_URL = "/api/store/items";
	

	public void givenItems(String input) {
		items = input.split("(?!^)");
		request = SerenityRest.given().accept(MediaType.APPLICATION_JSON_UTF8_VALUE);
	}

	public void whenAllItemsAreAddedToTheCart() {
		for(String item : items) {
			response = request.put(ADD_REMOVE_ITEM_URL + item);
		}
		
	}

	public void thenTheTotalPriceIsVerified(double d) {
		System.out.println(response.asString());
		assertEquals(d, response.thenReturn().body().jsonPath().getObject("payload", ItemCart.class).getTotalPrice(), .001);
	}
	
	public void emptyCart() {
		SerenityRest.given().accept(MediaType.APPLICATION_JSON_UTF8_VALUE).delete(GET_EMPTY_CART_URL);
	}
	

	

}
