@parabank2
Feature: Parabank Task Feature
  user should be able to complete Parabank assignment

  Background: Parabank side up
    Given I am on the home page of "https://parabank.parasoft.com/parabank/register.htm"

  Scenario: SignUp
    Then Parabank homepage is available
    When Enter firstname "Rutukanta" and lastname "Parida" and address "Chennai" and city "Chennai" and state "TamilNadu" and zipcode "600032" and phnNumber "9876541230" and SSN "789456" and username "UserMav" and password "Maveric123" and Confirmpassword "Maveric123"
    And Click on Register button
    Then New ID registered successfully
    And redirect to Parabank HomePage

  Scenario: Login
    Then Parabank homepage is available
    When Enter username "UserMav" and password "Maveric123"
    And Click on login button
    Then logged in successfully
    And redirect to Parabank Dashboard

  Scenario: AccountCreation
    Then Parabank homepage is available
    When click on OpenNewAccount menu
    And Select type of Account from dropdown
    And Click on OpenNewAccountButton button
    Then Account should created successfully
    And user should get successfully message

  Scenario: FundTransfer
    Then Parabank homepage is available
    When click on TransferFund menu
    And Enter type of Amount
    And Select account from fromAccountId dropdown
    And Click on transferButton button
    Then fundtransfer should done successfully
    And user should get successfully message

  Scenario: EntriesFundTransfer
    Then Parabank homepage is available
    When click on FindTransactions Menu
    And Select account no fromdropdown
    And Enter required date on date search field
    And Click on findTransaction button
    Then fundtransfer details verification should done successfully
    And user should get fundtransfer Details

  Scenario: LogOut
    When Required task completed
    And click on logOut Menu
    Then Application is logged out successfully
    And redirect to Parabank HomePage
