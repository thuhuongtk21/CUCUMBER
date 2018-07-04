Feature: Payment feature
  As an automation tester
  I want to create new customer
  So that I want to make sure payment correctly

  @payment
  Scenario Outline: Create new Customer and get NewCustomerID
    Given I input to "uid" textbox with data "mngr127701"
    And I input to "password" textbox with data "epEvAbe"
    When I click to "btnLogin" button
    Then I verify Homepage displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open "New Customer" page
    And I input to "name" textbox with data "<CustomerName>"
    And I click to "f" radio button
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<PIN>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with random data "<Email>@gmail.com"
    And I input to "password" textbox with data "<Password>"
    And I click to "sub" button
    And I input first Account ID
    And I input second Account ID
    And I input third Account ID
    Then Verify created or edited successfully with message "Customer Registered Successfully!!!"
    When Get CustomerID for edit customer function

    Examples: 
      | CustomerName | Gender | DateOfBirth | Address | City    | State  | PIN    | Phone      | Email   | Password |
      | Dao Minh Dam | m      | 16/10/1999  | Da nang | Da nang | Cam le | 456789 | 0123654898 | testing |   123456 |

  Scenario: Edit Customer
    Given I open "Edit Customer" page
    And Input CustomerID
    And I click to "AccSubmit" button
    And Input data to all fields required in Edit Customer page
      | Address     | City    | State  |
      | 123 Address | Da nang | Cam Le |
    And I click to "sub" button
    Then Verify created or edited successfully with message "Customer details updated Successfully!!!"
    And I verify data edit successfully
      | Address     | City    | State  |
      | 123 Address | Da nang | Cam Le |

  Scenario: Create 2 new accounts and transfer to first account 50000 USD
    Given I open "New Account" page
    When Input CustomerID
    And I select account type is "Current"
    And I transfer to first account is "50000"
    And I click to "button2" button
    Then Verify created or edited successfully with message "Account Generated Successfully!!!"
    When Get first AccountID
    Given I open "New Account" page
    When Input CustomerID
    And I select account type is "Current"
    And I transfer to first account is "10000"
    And I click to "button2" button
    Then Verify created or edited successfully with message "Account Generated Successfully!!!"
    When Get second AccountID
