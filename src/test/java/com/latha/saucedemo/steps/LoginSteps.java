package com.latha.saucedemo.steps;

import com.latha.saucedemo.pages.InventoryPage;
import com.latha.saucedemo.pages.LoginPage;
import com.latha.saucedemo.support.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private final InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open();
    }

    @Given("I am logged in as a standard user")
    public void iAmLoggedInAsAStandardUser() {
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");
        assertEquals("Products", inventoryPage.title());
    }

    @When("I log in as {string} with password {string}")
    public void iLogInAs(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Then("I should see the {string} page")
    public void iShouldSeeThePage(String expectedTitle) {
        assertEquals(expectedTitle, inventoryPage.title());
    }

    @Then("I should see the login error {string}")
    public void iShouldSeeTheLoginError(String expectedError) {
        assertEquals(expectedError, loginPage.errorText());
    }
}
