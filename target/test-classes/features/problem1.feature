@Test
Feature: Test

Scenario: 
Given the user is on the home page
When the user selects two items to purchase
Then the user should see selected two items in the cart
Then the user verifies the price of the item  changes accordingly as you change the quantity
Then the user verifies the total price matches the sum of two proces