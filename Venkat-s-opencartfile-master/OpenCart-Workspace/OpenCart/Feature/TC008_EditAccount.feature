Feature: Editing Account

  @EditingAccount
  Scenario Outline: Editing the Registerd Account
    Given User able to acces and login to the Application
    When User click on Edit Account Information
    And User update the <LastName> and click Continue
    Then Account Information should get updated successfully
    And User click on Logout and click on Continue to Return to Home Page

    Examples: 
      | LastName |
			| "test4"  |