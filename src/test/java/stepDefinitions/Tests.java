package stepDefinitions;

import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.OrderPage;
import utilities.Page;

public class Tests {
	HomePage homePage = new HomePage();
	OrderPage orderPage = new OrderPage();
	
	@Given("^the user is on the home page$")
	public void the_user_is_on_the_home_page(){
	    homePage.navigateTo();
	}

	@When("^the user selects two items to purchase$")
	public void the_user_selects_two_items_to_purchase(){
		homePage.selectItemsToPurchase(2);
	}

	@Then("^the user should see selected two items in the cart$")
	public void the_user_should_see_selected_two_items_in_the_cart(){
	    homePage.shoppingCart.click();
	    String message = orderPage.shoppingCartSummaryMessage.getText();
	    String[] array = message.split(" ");
	    int orderCount = Integer.valueOf(array[0]);
	    assertTrue(orderCount==2);
	}

	@Then("^the user verifies the price of the item  changes accordingly as you change the quantity$")
	public void the_user_verifies_the_price_of_the_item_changes_accordingly_as_you_change_the_quantity(){
	    orderPage.addQuantities(1, 2);
	    double unitPrice = orderPage.getUnitPrice(1);
	    Page.sleep(300);
	    double totalPrice = orderPage.getTotalPriceOfAnItem(1);
	    assertTrue(unitPrice * 3 == totalPrice);
	}

	@Then("^the user verifies the total price matches the sum of two proces$")
	public void the_user_verifies_the_total_price_matches_the_sum_of_two_proces(){
	    double sumOfPrices = orderPage.getSumOfPrices(2);
	    double totalProductsPrice = orderPage.getTotalProductsPrice();
	    assertTrue(sumOfPrices == totalProductsPrice);
	}

}
