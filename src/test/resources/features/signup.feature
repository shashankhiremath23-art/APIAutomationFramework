Feature: Account Creation

  Scenario: Complete signup successfully
    Given user is authenticated
    When user wants to signup
    Then account should be created successfully
