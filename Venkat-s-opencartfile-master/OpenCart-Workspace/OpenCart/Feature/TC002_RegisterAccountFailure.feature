Feature: Register Account Failure

  @RegisterAccountFailure
  Scenario Outline: To Check User not able to Create Account when any required fields is Missing
    Given User able to access Application Link
    When User should click My Account and Register
    And User should enter <FirstName> and <LastName> and <Email> and <Telephone> and <Password> and <PasswordConfirm> by Missing any Required Field
    And User should check Privacy Policy and click Continue
    Then User should able to capture the Error Message

    Examples: 
    	| FirstName | LastName | Email              | Telephone    | Password   | PasswordConfirm |
    	| "v22"     | "Test"   | "v22Test@test.com" | " "          | "Test@123" | "Test@123"      |
