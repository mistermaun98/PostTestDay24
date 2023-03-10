Feature: Login User HRM
  Scenario: User successful login into web HRM #done
    Given User open browser and url
    When User enter valid username
    And User enter valid password
    And User click button login
    Then User go to page Dashboard

  Scenario: User use valid username and invalid password #done
    When User click button logout
    And User enter valid username
    And User enter invalid password
    And User click button login
    Then User get message invalid credentials

  Scenario: User use invalid username and valid password #Done
    When User enter invalid username
    And User enter valid password
    And User click button login
    Then User get message invalid credentials

  Scenario: User use invalid username and password #done
    When User enter invalid username and password
    And User click button login
    Then User get message invalid credentials

  Scenario: Login with empty username credentials
    When Page is refreshed
    And User enter valid username
    And User click button login
    Then User get message required username credentials

  Scenario: Login with empty password credentials
    When Page is refreshed
    And User enter valid password
    And User click button login
    Then User get message required password credentials

  Scenario: Login with empty credentials
    When Page is refreshed
    And User click button login
    Then User get message required both credentials
