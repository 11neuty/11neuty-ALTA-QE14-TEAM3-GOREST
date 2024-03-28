Feature: Delete todos
  As user i can delete todos by valid id and user id, and cant delete todos by invalid id and user id\
  @API
  #Positive test case
  Scenario: As user i can delete todos by valid id
    Given   Delete todos by id 46630
    When    Send request to delete todos
    Then    Status code should be 204

#Negative test case
  Scenario: As user i cant delete todos by invalid id
    Given   Delete todos by id 8231
    When    Send request to delete todos
    Then    Status code should be 404
