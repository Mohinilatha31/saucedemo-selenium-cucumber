Feature: Shopping cart
  As a logged-in shopper
  I want to add products to my cart
  So that I can buy them later

  Background:
    Given I am logged in as a standard user

  @smoke
  Scenario: Add one product to the cart
    When I add "Sauce Labs Backpack" to the cart
    Then the cart badge should show 1
    And the cart should contain "Sauce Labs Backpack"

  Scenario: Add two products to the cart
    When I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bike Light" to the cart
    Then the cart badge should show 2
    And the cart should contain "Sauce Labs Bike Light"
