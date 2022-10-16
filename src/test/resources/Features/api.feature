@api
Feature: API Testing
  Scenario: Add a new pet to the store
    Given   user add pet to the store
    When    user should see the result in server

  Scenario: Get pet id
    Given   user find the pet by id
    When    user should get pet id result
