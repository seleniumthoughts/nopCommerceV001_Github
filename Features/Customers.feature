@All
Feature: Customers

Background: Below are the common steps for each Scenarios
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login" 
And User Enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then User can view Dashboard
When User Click on customers Menu
And Click on customers Menu Item

@smoke
Scenario: Add New Customer
And Click on Add new button
Then User can view Add New Cuctomer Page
When User enter Customer info
And click on Save button
Then User can view confirm message "The new customer has been added successfully."
And Close browser

@regression 
Scenario: Search Customer by EmailID
And Enter Customer Email
When User Click on Search button
Then User Should found Email in the Search Table
And Close browser

@regression
Scenario: Search Customer by Name
And Enter Customer FirstName
And Enter Customer LastName
When User Click on Search button
Then User Should found Name in the Search Table
And Close browser

