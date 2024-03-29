Feature: Delete todos
  As user i can delete todos by valid id, and cant delete todos by invalid id

  @Project
  #Positive test case
  Scenario: As user i can delete todos by valid id
    Given   Delete todos by id 46676
    When    Send request to delete todos
    Then    Status code should be 204

  @Project
  #Negative test case
  Scenario: As user i cant delete todos by invalid id
    Given   Delete todos by id 8231
    When    Send request to delete todos
    Then    Status code should be 404