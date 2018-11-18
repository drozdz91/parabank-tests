Feature: Login to application

  Scenario: Should login
    Given System displays login page
    When User fills username as "Mat" with password "test"
    Then User is logged in

  Scenario: Should not login without username
    Given System displays login page
    When User fills username as "" with password "test"
    Then User is not logged in

  Scenario: Should not login without password
    Given System displays login page
    When User fills username as "Mat" with password ""
    Then User is not logged in