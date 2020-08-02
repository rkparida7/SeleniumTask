@ParaBankTest
Feature: ParaBank Task
  login to Parabank site Open a account and do a Fund transfer

  @tag1
  Scenario Outline: To do a fund transfer in ParaBank Site
    Given Launch the paraBank Site
    And create New IDs "<username>" and "<password>"
    Then Enter the User Name and password and click login button "<username>" and "<password>"
    And Navigate to Open New Account section
    When Select the Account Type "<accounttype>" and Click Open new accountButton
    Then A New account is Created successfully
    When Click the Transfer Funds option
    And Enter the Amount "<amount>" to be transferred
    And Select required the Account number from dropdown 
    And Click TransferButton
    Then Fund transfer should done successfully
    When Click the Accounts Overview Option
    And Select the corresponding Account from the table
   	And Selelct the currentDate "<date>" from the table
    Then Details of the Account is displayed
    And Account activity details displayed
    When Click on Logout option
    Then Successfully logged out from Parabank Site
  
   
Examples:
| username  | password    | accounttype| amount | 		date   | 
| 	MavUser1 	| PASSWORD1   | SAVINGS    | 100	|	08-01-2020 |
#| 	MavUser2 	| PASSWORD1   | SAVINGS    | 100	|	08-01-2020 |



#MavericUser8
#PASSWORD01

   
 