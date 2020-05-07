Feature:
  Verify POST operations for Infected API

  Scenario: Verify its possible to add UK to the infected list.
    Given I perform POST operation to my Test environment
    And I set my POST body to "UK" and its value to 666 and id to 5
    When I perform POST request to "https://my-json-server.typicode.com/adrianszczesny0/rest/Infected"
    Then I should get response with code 201
    And I should get response with body containing "UK"