@hotel-regression @hotel-search @web
Feature: Hotel Search Feature

  Background:
    Given I am on hotel website homepage

  @hotel-search-1
  Scenario: Verify deal of the day price amount
    When I select destination as New York City
    And I select checking date as 1 and checkout date as 8
    And I select 2 More options... from home page
    And I select room as 1
    And I select adult as 2
    And I select children as 2
    And I select childone as 2
    And I select childtwo as 3
    And I click on search button
    Then I verify deal of the day hotel price is between 200 to 300