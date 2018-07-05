
Feature: PAYMENT FUNCTION
  As an automation test
  I want to create an Account
  So that I can verify register function work well

  Scenario: [PAYMENT] - CREATE NEW ACCOUNT
    Given I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button at register page
    Then I get to username information
    And I get to password information

  Scenario: [PAYMENT] - LOGIN WITH INFORMATION ABOVE
    Given I open to login page
    When I input to username textbox
    And I input to password textbox
    And I input to submit button at login page
    Then I verify homepage welcome message displayed
    

  Scenario: [PAYMENT] - CUCUMBER REGEX
    Given I open to login page
    When I input first Account ID
    And I input second Account ID
    And I input third Account ID
    
    And I transfer to "<Amount>" USD
    And I withdraw to "<Amount>" USD
    
    Then I verify homepage welcome message displayed

  Scenario Outline: [PAYMENT] - CREATE NEW CUSTOMER
    Given I click to New Customer Page
    And I input all information to this page
      | CustomerName   | Gender   | DateOfBirth   | Adress   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Adress> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to submit button
    Then I verify customer created success with information
      | CustomerName   | Gender   | DateOfBirth   | Adress   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Adress> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |

    Examples: 
      | CustomerName    | Gender | DateOfBirth | Adress      | City    | State    | Pin    | Phone     | Email | Password |
      | Automation Test | male   | 01/02/1995  | 123 Address | Da Nang | Hai Chau | 123456 | 123456789 | auto  |   111111 |
