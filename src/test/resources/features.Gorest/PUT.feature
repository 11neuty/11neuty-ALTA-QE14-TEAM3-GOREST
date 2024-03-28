Feature: Put todos
  As user i can update todos by valid id and cant update todos by invalid id
  @API
  #Positive test case

  Scenario: As user i can update todos by valid id and json body request
    Given   Update todos with id 46628 and json "validUpdate.json"
    When    Send request to update todos
    Then    Status code should be 200

   #Negative test case
  Scenario: As user i cant update todos by invalid json body request
    Given   Update todos with id 46628 and json "invalidUpdate.json"
    When    Send request to update todos
    Then    Status code should be 422


  Scenario: As user i cant update todos by invalid id
    Given   Update todos with id 465 and json "validUpdate.json"
    When    Send request to update todos
    Then    Status code should be 404