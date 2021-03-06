Feature: User Account Registration

  @RegisterAccount
  Scenario Outline: Register Account with User Details
    Given User have access to Open Cart Link
    When User should click My Account and click Register
    And User should enter <FirstName> and <LastName> and <Email> and <Telephone> and <Password> and <PasswordConfirm>
    And User should check Privacy Policy
    And Click continue
    Then User should able to Create Account successfully

    Examples: 
    	| FirstName | LastName | Email              | Telephone    | Password   | PasswordConfirm |
    	| "v47"     | "Test"   | "v47Test@test.com" | "8638082344" | "Test@123" | "Test@123"      |