@account
Feature: CREATE ACCOUNT
  As an automation test
  I want to create an Account
  So that I can verify register function work well

  Scenario Outline: Create new Account
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
    When I click to New Customer Page
    And I input all information to this page
      | CustomerName   | Gender   | DateOfBirth   | Adress   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Adress> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to submit button
    And I verify customer created success with information
      | CustomerName   | Gender   | DateOfBirth   | Adress   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Adress> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I close browser

    Examples: 
      | CustomerName    | Gender | DateOfBirth | Adress      | City    | State    | Pin    | Phone     | Email | Password |
      | Automation Test | male      | 01/02/1995  | 123 Address | Da Nang | Hai Chau | 123456 | 123456789 | auto  |   111111 |
