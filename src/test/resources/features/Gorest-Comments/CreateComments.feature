@Comment
Feature: Gorest create comment

  @Project
  Scenario: Create comments with valid json
    Given Create comments with valid post id 115651 json "CreateCommentValid.json"
    When Send request create new comment
    Then Status code should be 201

  @Project
  Scenario: Create comments with unregistered user id
    Given Create comments with invalid post id 1 json "CreateCommentUnregistered.json"
    When Send request create new comment
    Then Status code should be 422