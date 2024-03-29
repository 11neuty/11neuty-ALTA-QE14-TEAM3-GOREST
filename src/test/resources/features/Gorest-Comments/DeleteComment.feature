@Comment
Feature: Delete Comment

  Scenario: Delete comment with valid comment id
    Given Delete comment with valid comment id 90639
    When Send request delete user
    Then  Status code should be 204

  Scenario: Delete comment with valid comment id
    Given Delete comment with valid comment id 1
    When Send request delete user
    Then  Status code should be 204
