package company.api.store.items.bdd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SpringIntegrationSerenityRunner.class)
public class ItemsAcceptanceBDD {
	
	@Steps
	private ItemsAcceptanceBDDSteps steps;
	
	@Before
	public void setup() {
		steps.emptyCart();
	}
	
	@Test
	public void testABCDABA() {
		steps.givenItems("ABCDABA");
		steps.whenAllItemsAreAddedToTheCart();
		steps.thenTheTotalPriceIsVerified(13.25);
	}
	
	@Test
	public void testCCCCCCC() {
		steps.givenItems("CCCCCCC");
		steps.whenAllItemsAreAddedToTheCart();
		steps.thenTheTotalPriceIsVerified(6.00);
	}
	
	@Test
	public void testABCD() {
		steps.givenItems("ABCD");
		steps.whenAllItemsAreAddedToTheCart();
		steps.thenTheTotalPriceIsVerified(7.25);
	}

}
