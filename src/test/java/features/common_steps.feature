Feature: PAYMENT FEATURE
  As an automation test
  I want to create new Customer
  So that I can make sure payment correctly

  @payment1
  Scenario Outline: Create new Customer and get NewCustomerID
    Given I input to "uid" textbox with data "mngr134681"
    And I input to "password" textbox with data "mudUhaj"
    When I click to "btnLogin" button
    Then I verify Homepage displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open "New Customer" page
    And I input to "name" textbox with data "<CustomerName>"
    And I click to "f" radio button
    And I input to "dob" textbox with data "<DataOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<Pin>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with random data "<Email>@gmail.com"
    And I input to "password" textbox with data "<Password>"
    And I click to "sub" button
    And I input first Account ID
    And I input second Account ID
    And I input third Account ID
    Then Verify created or edited successfully with message "Customer Registered Successfully!!!"
    When Get CustmerID for edit customer function
    And I verify expected data at "name" textbox with actual data "<CustomerName>"
    And I verify expected data at "city" textbox with actual data "<City>"
    And I verify expected data at "address" textbox with actual data "<Adress>"
    And I open "New Customer" page
    And I open "Edit Customer" page
    And I open "Delete Customer" page

    Examples: 
      | CustomerName    | Gender | DateOfBirth | Adress      | City    | State    | Pin    | Phone     | Email | Password |
      | Automation Test | male   | 01/02/1995  | 123 Address | Da Nang | Hai Chau | 123456 | 123456789 | auto  |   111111 |

  Scenario: Edit Customer
    Given I open "Edit Customer" page
    And I input CustomerID
    And I click to "AccSubmit" button
    And I input data to all fields required in Edit Customer page
      | Address     | City    | State    |
      | 123 Address | Da Nang | Hai Chau |
    And I click to "sub" button
    Then Verify created or edited successfully with message "Customer details updated Successfully!!!"
    And I verify data edit successfully
      | Address     | City    | State    |
      | 123 Address | Da Nang | Hai Chau |
