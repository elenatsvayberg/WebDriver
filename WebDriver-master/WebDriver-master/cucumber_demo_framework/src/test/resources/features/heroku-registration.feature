@web @heroku-regression
Feature: Heroku Registration Feature

  Background:
    Given I am on Registration page

  @heroku-registration
  Scenario: Verify a new user can register with a valid email address
    When I enter name as testuser email as test@test.com password as test12345
    And I click submit button
    Then I am signed-in as a new user

  @heroku-email
  Scenario Outline: Verify invalid email on registration
    When I enter name as testuser email as <email> password as test12345
    And I click 'submit' button
    Then  I verify invalid email address

    Examples:
      | email |
      | test.com |
      | test@test@test.com |