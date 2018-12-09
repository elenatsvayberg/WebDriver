@darksky-regression @web @darksky-smoketest
Feature: Darksky Feature

  Background:
    Given I am on Darksky website homepage

  @darksky-verifytemp
  Scenario: Verify current temperature is between low and high value
    When I clear search field
    And I enter 10001 into the search field
    And I click on search magnifying glass
    Then I verify current temperature is between low and high value

  @darsky-temptimeline
  Scenario: Verify timeline is displayed in correct format
    Then I verify timeline is displayed with two hours incremented

  @darksky-daytemp
  Scenario: Verify individual day temp timeline
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly

  @darksky-todaysdate
  Scenario: Verify Time Machine Calendar
    When I click on Time Machine
    Then I verify date is selected to todays date

