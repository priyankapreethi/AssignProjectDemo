@ui
Feature: Sports Functionality

  Background: Pre condition to run all the below scenarios
    Given the Mail Online home page
    And the Sports page
    And the Football page

  Scenario: verify the Sports background color
     Then user should see the highlighted color as "#0cac0c"

  Scenario: verify Football page
    Then user should see the Football page

  Scenario: verify the gallery functionality
    When user click on the first article
    And user click on gallery icon
    Then user should be able to move Next gallery images
    And user should be able to move Previous gallery images

  Scenario:  verify the video player resizing
    When user click on the first article
    Then user should be able to resize the video

  Scenario: verify the Facebook social share
    When user click on the Facebook share icon
    Then user should be able to see the facebook portal





