Feature: Sports Functionality

  Scenario: verify sports menu
    Given   the Mail Online home page
    When    user click on the sport menu
    And     user should see the sports page

  Scenario: verify the gallery icon
    Given   the Mail Online home page
    When    user click on gallery icon
    Then    user should see the multiple gallery images