Feature: Remove Product

  @RemoveProduct
  Scenario: Removing Product from Cart
    Given User has able to access and login to Application with Login Details
    When User click on Laptop & Notebook
    And User select show all Option
    And User select the Product and click Add to Cart Button
    And User navigate to Shopping cart and click the Shopping Cart
    And User remove the item from the cart and click continue
    Then User able to remove the product from cart Successfully
