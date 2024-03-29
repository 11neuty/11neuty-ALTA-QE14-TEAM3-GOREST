@Comment
Feature: Update Comment

  @Project
  Scenario: Update Comment with valid JSON and user id
    Given Update comment with valid JSON "updateComment.json" and comment id 90667
    When Send request update comment
    Then Status code should be 200

  @Project
  Scenario: Update Comment with valid JSON and unregistered comment id
    Given Update comment with valid JSON "updateComment.json" and unregistered comment id 1
    When Send request update comment
    Then Status code should be 404