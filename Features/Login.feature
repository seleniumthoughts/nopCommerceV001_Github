
Feature: Login

@sanity
Scenario: Successful Login With Valid Credentials
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login" 
And User Enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out Link
Then Page Title should be "Your store. Login"
And Close browser

@regression
Scenario Outline: Login Data Driven
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login" 
And User Enters Email as "<email>" and Password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out Link
Then Page Title should be "Your store. Login"
And Close browser

Examples:
      | email | password |
      | admin@yourstore.com | admin |
      | admin@yourstore.com | admin |