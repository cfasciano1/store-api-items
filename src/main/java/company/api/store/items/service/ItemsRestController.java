package company.api.store.items.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.api.store.items.exceptions.InvalidItemActionException;
import company.api.store.items.model.Item;
import company.api.store.items.model.ItemCart;
import company.api.store.items.model.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/store/")
@Api(tags = "Items")
public class ItemsRestController {
    
	@Autowired
	ItemsService itemsService;
		
    @PutMapping(path = "/item/{item}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
    	@ApiResponse(code = 200, message = "Item successfully added to cart"),
    	@ApiResponse(code = 400, message = "Cannot add invalid item"),
    	@ApiResponse(code = 500, message = "Error occured while adding item" )})
    public ResponseEntity<Response<ItemCart>> addItem(@ApiParam(value = "item", required = true)@PathVariable Item item) {
    	ItemCart cart = itemsService.addItem(item, 1);
        return new ResponseEntity<Response<ItemCart>>(new Response<ItemCart>(cart), HttpStatus.OK);
    }
    
    @GetMapping(path = "/items", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
        	@ApiResponse(code = 200, message = "Items successfully retrieved"),
        	@ApiResponse(code = 500, message = "Error occured while retrieving cart" )})
    public ResponseEntity<Response<ItemCart>> getCart() {
    	ItemCart cart = itemsService.getCart();
    	return new ResponseEntity<Response<ItemCart>>(new Response<ItemCart>(cart), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/item/{item}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
        	@ApiResponse(code = 200, message = "Item successfully removed to cart"),
        	@ApiResponse(code = 400, message = "Cannot remove invalid/nonexistant item"),
        	@ApiResponse(code = 500, message = "Error occured while removing item" )})
    public ResponseEntity<Response<ItemCart>> removeItem(@ApiParam(value = "item", required = true)@PathVariable Item item) throws InvalidItemActionException {
    	ItemCart cart = itemsService.removeItem(item, 1);
    	return new ResponseEntity<Response<ItemCart>>(new Response<ItemCart>(cart), HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/items", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
        	@ApiResponse(code = 200, message = "Successfully cleared the cart"),
        	@ApiResponse(code = 500, message = "Error occured while clearing the cart" )})
    public ResponseEntity<Response<ItemCart>> emptyCart() {
    	ItemCart cart = itemsService.emptyCart();
    	return new ResponseEntity<Response<ItemCart>>(new Response<ItemCart>(cart), HttpStatus.OK);
    }
    
    
}
