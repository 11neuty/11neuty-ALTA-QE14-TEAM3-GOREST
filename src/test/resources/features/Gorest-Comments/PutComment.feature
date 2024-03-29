@Comment
Feature: Update Comment

  Scenario: Update Comment with valid JSON and user id
    Given Update comment with valid JSON "Update Comment" and comment id 90639
    When Send request update comment
    Then Status code should be 200

  Scenario: Update Comment with valid JSON and unregistered comment id
    Given Update comment with valid JSON "Update Comment" and unregistered comment id 1
    When Send request update comment
    Then Status code should be 404