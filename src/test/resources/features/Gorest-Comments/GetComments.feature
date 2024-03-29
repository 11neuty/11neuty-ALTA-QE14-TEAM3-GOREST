@Comment
Feature: Get Comment

  @Project
  Scenario: Get comment with valid comment id
    Given Get comment with valid comment id 90639
    When Send request get comment
    Then Status code should be 200

  @Project
  Scenario: Get comment with unregistered comment id
    Given Get comment with unregistered comment id 1
    When Send request get comment
    Then Status code should be 404