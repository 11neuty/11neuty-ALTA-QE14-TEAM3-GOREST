@Comment
Feature: Get Comment

  @Project
  Scenario: Get list comments without comment id
    Given Get list comments without comment id
    When Send request get list comment
    Then Status code should be 200

  @Project
  Scenario: Get comment with valid comment id
    Given Get comment with valid comment id 90606
    When Send request get comment
    Then Status code should be 200

  @Project
  Scenario: Get comment with unregistered comment id
    Given Get comment with unregistered comment id 1
    When Send request get comment
    Then Status code should be 404