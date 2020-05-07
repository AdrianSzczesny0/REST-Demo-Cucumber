Feature:
  Verify GET operations for Infected API

  Scenario: Verify POLAND is on the infected list.
    Given I perform GET operation to my Test environment
    When I perform GET request to "/rest/Infected/1"
    Then I should get resposne with status code  of 200
    And I get a response contains country  "POLAND"