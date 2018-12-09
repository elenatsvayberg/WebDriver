@web @heroku-regression
Feature: Heroku Home Feature

  Background:
    Given I am on Heroku home page

  @heroku-search
  Scenario: Verify search title
    When I search on top search bar with text ios
    Then I verify Title: I will teach you IOS as displayed result

  @heroku-check
  Scenario:  Verify total number of posts on home page
    Then I verify 94 total post is displayed
    And I verify 94 post has price tag
    And I verify 94 post has title
    And I verify 94 post has displayed image
