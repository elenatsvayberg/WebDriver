@web @heroku-regression
Feature: Heroku Login Feature

  Background:
    Given User is on the Heroku login page

  @heroku-login
  Scenario: Verify valid login
    When I enter username as n12345@test.com and password as 123456
    And I click on submit button
    Then I verify Logout button is displayed