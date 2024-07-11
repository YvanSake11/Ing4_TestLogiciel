@account
Feature: Account user
  @open_modal
  Scenario: open modal
    Given user in the page
    When user click avtar in navbar
    Then modal is open
