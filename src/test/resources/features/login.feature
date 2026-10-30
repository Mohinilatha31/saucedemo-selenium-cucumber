Feature: Login
  As a shopper
  I want to log in to the shop
  So that I can browse and buy products

  Background:
    Given I am on the login page

  @smoke
  Scenario: Successful login with valid credentials
    When I log in as "standard_user" with password "secret_sauce"
    Then I should see the "Products" page

  Scenario Outline: Login is rejected with invalid credentials
    When I log in as "<username>" with password "<password>"
    Then I should see the login error "<error>"

    Examples:
      | username        | password       | error                                                                      |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                        |
      | standard_user   | wrong_password | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce   | Epic sadface: Username is required                                         |
