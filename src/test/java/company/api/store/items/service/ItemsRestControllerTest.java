package company.api.store.items.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import company.api.store.items.model.Item;
import company.api.store.items.model.ItemCart;
import company.api.store.items.model.Response;

@RunWith(MockitoJUnitRunner.class)
public class ItemsRestControllerTest {
	
	@InjectMocks
	private ItemsRestController controllerUnderTest;
	
	@Mock
	private ItemsService mockService;
	

	private MockMvc mvc;
	private ObjectMapper objectMapper;
	
	private static final String ADD_REMOVE_ITEM_URL = "/api/store/item/{item}";
	private static final String GET_EMPTY_CART_URL = "/api/store/items";
	
	@Before
	public void setup() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		jsonConverter.setObjectMapper(objectMapper);
		mvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).setMessageConverters(jsonConverter).build();
	}
	
	@Test
	public void testAddItem() throws Exception {
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 1);
		cart.setTotalPrice(1.25);
		Response<ItemCart> expectedResponse = new Response<>(cart);
		String expectedJson = objectMapper.writeValueAsString(expectedResponse);
	
		when(mockService.addItem(Item.A, 1)).thenReturn(cart);
		
		mvc.perform(put(ADD_REMOVE_ITEM_URL, "A").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedJson, true));
		
		verify(mockService).addItem(Item.A, 1);	
	}
	
	@Test
	public void testRemoveItem() throws Exception {
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 1);
		cart.setTotalPrice(1.25);
		Response<ItemCart> expectedResponse = new Response<>(cart);
		String expectedJson = objectMapper.writeValueAsString(expectedResponse);
	
		when(mockService.removeItem(Item.A, 1)).thenReturn(cart);
		
		mvc.perform(delete(ADD_REMOVE_ITEM_URL, "A").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedJson, true));
		
		verify(mockService).removeItem(Item.A, 1);	
	}
	
	@Test
	public void testGetCart() throws Exception {
		ItemCart cart = new ItemCart();
		cart.getItems().put(Item.A, 1);
		cart.setTotalPrice(1.25);
		Response<ItemCart> expectedResponse = new Response<>(cart);
		String expectedJson = objectMapper.writeValueAsString(expectedResponse);
	
		when(mockService.getCart()).thenReturn(cart);
		
		mvc.perform(get(GET_EMPTY_CART_URL).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedJson, true));
		
		verify(mockService).getCart();	
	}
	
	@Test
	public void testEmptyCart() throws Exception {
		ItemCart cart = new ItemCart();
		Response<ItemCart> expectedResponse = new Response<>(cart);
		String expectedJson = objectMapper.writeValueAsString(expectedResponse);
	
		when(mockService.emptyCart()).thenReturn(cart);
		
		mvc.perform(delete(GET_EMPTY_CART_URL).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedJson, true));
		
		verify(mockService).emptyCart();	
	}

}
