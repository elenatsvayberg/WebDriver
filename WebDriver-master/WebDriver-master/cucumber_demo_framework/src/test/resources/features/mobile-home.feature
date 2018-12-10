@mobile-regression @mobile-home @mobile
Feature: Mobile Home Feature

  Background:
    Given I am on a home page of the app

  @mobile-home-reset
  Scenario: Verify all options are enabled
    When I click on filter button
    And I disable Angular option
    And I click on All Reset Filer button
    Then I verify all options are enabled

    @mobile-home-slide
    Scenario: Verify user should be able to slide right on tutorial pages
      When I swipe right 3 times on tutorials slides
      Then I verify Continue button is displayed