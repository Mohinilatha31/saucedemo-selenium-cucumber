Feature: Checkout
  As a shopper with items in my cart
  I want to complete my order
  So that the products are delivered to me

  Background:
    Given I am logged in as a standard user
    And I add "Sauce Labs Backpack" to the cart

  @smoke
  Scenario: Complete an order successfully
    When I check out with first name "Latha", last name "Test" and postcode "1011AB"
    And I finish the order
    Then I should see the order confirmation "Thank you for your order!"

  Scenario: Checkout is blocked without a postcode
    When I check out with first name "Latha", last name "Test" and postcode ""
    Then I should see the checkout error "Error: Postal Code is required"
