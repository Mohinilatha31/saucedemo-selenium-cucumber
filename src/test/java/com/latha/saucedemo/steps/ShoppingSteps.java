package com.latha.saucedemo.steps;

import com.latha.saucedemo.pages.CartPage;
import com.latha.saucedemo.pages.CheckoutPage;
import com.latha.saucedemo.pages.InventoryPage;
import com.latha.saucedemo.support.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingSteps {

    private final InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());
    private final CartPage cartPage = new CartPage(DriverFactory.getDriver());
    private final CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());

    @When("I add {string} to the cart")
    public void iAddToTheCart(String productName) {
        inventoryPage.addToCart(productName);
    }

    @Then("the cart badge should show {int}")
    public void theCartBadgeShouldShow(int expectedCount) {
        assertEquals(expectedCount, inventoryPage.cartCount());
    }

    @Then("the cart should contain {string}")
    public void theCartShouldContain(String productName) {
        inventoryPage.openCart();
        assertTrue(cartPage.productNames().contains(productName),
                "Expected the cart to contain " + productName);
    }

    @When("I check out with first name {string}, last name {string} and postcode {string}")
    public void iCheckOutWith(String firstName, String lastName, String postcode) {
        inventoryPage.openCart();
        cartPage.checkout();
        checkoutPage.enterDetails(firstName, lastName, postcode);
    }

    @When("I finish the order")
    public void iFinishTheOrder() {
        checkoutPage.finish();
    }

    @Then("I should see the order confirmation {string}")
    public void iShouldSeeTheOrderConfirmation(String expectedText) {
        assertEquals(expectedText, checkoutPage.confirmationText());
    }

    @Then("I should see the checkout error {string}")
    public void iShouldSeeTheCheckoutError(String expectedError) {
        assertEquals(expectedError, checkoutPage.errorText());
    }
}
