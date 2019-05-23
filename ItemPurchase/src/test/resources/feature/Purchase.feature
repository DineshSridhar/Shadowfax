
@tag
Feature: To Buy OPPO Mobile from Electronic and Mobile Section
  

  @tag1
  Scenario: Need to Add mobile in cart and to purchase mobile through Netbanking
    Given User sould be in Flipkart page to buy a Product
    And User should navigate to Electronics and Mobile section to select Oppo A3S Mobile
    When User should click on ADD cart
    When User should Click on Flipkart main icon to go back to home screen
    When User should navigate back by Click on Cart and verify if item exists in the page
    When User Click on Place Order
    When User Should Login using their account
    When Add order confirmation email and press continue
    When On payments options select net banking select Corporation Bank
    Then Take screenshot of the Bank screen
    
  