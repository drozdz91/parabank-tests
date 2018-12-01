Feature: Register an account in application

  Scenario: Should register
    Given System displays register page
    When User fills first name as "Mat"
    And User fills last name as "Dro"
    And User fills address as "Teczowa"
    And User fills city as "Koszalin"
    And User fills state as "zachodniopomorskie"
    And User fills zip code as "11-111"
    And User fills ssn as "12345"
    And User fills username as "Mat"
    And User fills password as "test"
    And User fills confirmation password as "test"
    And User clicks REGISTER button
    Then User is registered in application