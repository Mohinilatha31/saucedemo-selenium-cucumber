package com.latha.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector("[data-test='complete-header']");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterDetails(String first, String last, String postcode) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, postcode);
        click(continueButton);
    }

    public void finish() {
        click(finishButton);
    }

    public String confirmationText() {
        return textOf(completeHeader);
    }

    public String errorText() {
        return textOf(errorMessage);
    }
}
