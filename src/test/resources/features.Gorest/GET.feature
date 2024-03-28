Feature: GET TODOS
  As user i can get todos by valid id and user id, and cant get todos by invalid id and user id
  @API
    #POSITIVE TEST CASE
  Scenario: As user i can get all todos
    Given  Get all todos with valid page
    When   Send request get all todos
    Then   Status code should be 200

  Scenario: As user i can get single user todos by valid id
    Given Get user todos by id 46560
    When  Send request get todos by id
    Then  Status code should be 200

  Scenario: As user i can get single user todos by valid user id
    Given Get user todos by user id 6806879
    When  Send request get todos by user id
    Then  Status code should be 200

    #Negative test case
  Scenario: As user i cant get todos by invalid id
    Given   Get user todos by id 465
    When    Send request get todos by id
    Then    Status code should be 404

  Scenario: As user i cant get todos by invalid user id
    Given   Get user todos by user id 680
    When    Send request get todos by user id
    Then    Status code should be 404

  Scenario: As user i cant get todos by valid id and invalid method (put)
    Given   Get user todos by id 46560
    When    Send request get todos by invalid method
    Then    Status code should be 404


