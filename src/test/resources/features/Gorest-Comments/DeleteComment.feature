@Comment
Feature: Delete Comment

  @Project
  Scenario: Delete comment with valid comment id
    Given Delete comment with valid comment id 90665
    When Send request delete comment
    Then  Status code should be 204

  @Project
  Scenario: Delete comment with invalid comment id
    Given Delete comment with invalid comment id 1
    When Send request delete comment
    Then  Status code should be 404
