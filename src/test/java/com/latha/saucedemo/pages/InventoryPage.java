package com.latha.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String title() {
        return textOf(pageTitle);
    }

    /** "Sauce Labs Backpack" -> button data-test="add-to-cart-sauce-labs-backpack" */
    public void addToCart(String productName) {
        click(By.cssSelector("[data-test='add-to-cart-" + toSlug(productName) + "']"));
    }

    public int cartCount() {
        return isShown(cartBadge) ? Integer.parseInt(textOf(cartBadge)) : 0;
    }

    public void openCart() {
        click(cartLink);
    }

    private static String toSlug(String productName) {
        return productName.toLowerCase().trim().replaceAll("[^a-z0-9]+", "-");
    }
}
