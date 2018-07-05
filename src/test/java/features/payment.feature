@payment
Feature: Payment feature
  As an automation tester
  I want to create new customer
  So that I want to make sure payment correctly

  Scenario: [PRE-DATA] - REGISTER/LOGIN
    Given I get login url
    And I click to here link
    When I input to "emailid" textbox with random data ""
    And I click to "btnLogin" button
    And I get infor of User ID
    And I get infor of Password
    And I open login page again
    And I input to UserID textbox
    And I input to Password textbox
    And I click to "btnLogin" button
    Then I verify Homepage displayed with message "Welcome To Manager's Page of Guru99 Bank"

  Scenario Outline: [TC-01] - CREATE NEW CUSTOMER
    Given I open "New Customer" page
    When I input to "name" textbox with data "<CustomerName>"
    And I click to "rad1" radio button with data "<Geder>"
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<PIN>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with random data "automation@gmail.com"
    And I input to "password" textbox with data "<Password>"
    And I click to "sub" button
    And I get infor of Customer ID
    Then Verify created or edited successfully with message "Customer Registered Successfully!!!"
    And I verify expected data at "Customer Name" text in table with actual data "<CustomerName>"
    And I verify expected data at "Gender" text in table with actual data "<DateOfBirth>"
    And I verify expected data at "Birthdate" text in table with actual data "<DateOfBirth>"
    And I verify expected data at "Address" text in table with actual data "<Adress>"
    And I verify expected data at "City" text in table with actual data "<City>"
    And I verify expected data at "State" text in table with actual data "<State>"
    And I verify expected data at "Pin" text in table with actual data "<PIN>"
    And I verify expected data at "Mobile No." text in table with actual data "<Phone>"
    And I verify expected data at "Email" text in table with actual data "<Email>"
    

    Examples: 
      | CustomerName | Gender | DateOfBirth | Address | City    | State  | PIN    | Phone      | Email      | Password |
      | Automatio    | m      | 1989-10-10  | Da nang | Da nang | Cam le | 456789 | 1236548989 | automation |   123456 |

  Scenario Outline: [TC-02] - CREATE 2 NEW ACCOUNTS
    Given I open "New Account" page
    When I input to Customer ID
    And I select value is "<AccountType>" in dropdown list "selaccount"
    And I input to "inideposit" textbox with data "<DepositAmount>"
    And I click to "button2" button
    Then Verify created or edited successfully with message "Customer details updated Successfully!!!"
    And I get infor of first account
    When I open "New Account" page
    And I input to Customer ID
    And I select value is "<Account Type>" in dropdown list "selaccount"
    And I input to "inideposit" textbox with data "<DepositAmount>"
    And I click to "button2" button
    Then Verify created or edited successfully with message "Customer details updated Successfully!!!"
    And I get infor of second account

    Examples: 
      | AccountType | DepositAmount |
      | Current     |          5000 |

  Scenario Outline: [TC-02] - DEPOSIT TO ACCOUNTS
    Given I open "Deposit" page
    When I input to first account number
    And I input to "amount" textbox with data "<FirstAmount>"
    And I input to "desc" textbox with data "<DepositDesc>"
    And I click to "AccSubmit" button
    Then Verify created or edited successfully with message "Customer details updated Successfully!!!"

    Examples: 
      | AccountType | FirstAmount | DepositDesc        |
      | Current     |        5000 | Deposit to Account |
