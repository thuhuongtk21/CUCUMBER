@account
Feature: CREATE ACCOUNT
  As an automation test
  I want to create an Account
  So that I can verify register function work well


  Scenario: Create new Account
    Given I open browser
    And I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button at register page
    And I get to username information
    And I get to password information
    And I open to login page
    And I input to username textbox
    And I input to password textbox
    And I input to submit button at login page
    Then I verify homepage welcome message displayed
    And I close browser
