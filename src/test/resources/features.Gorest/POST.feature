Feature: Post todos
  As user i can post todos by valid user id and cant create post by invalid user id
@API
  #Test case positive
  Scenario: As user i can post todos by valid user id
    Given   Create todos by user id 6810624 and valid json "validTodos.json"
    When    Send request create todos
    Then    Status code should be 201

   #Test case negative
  Scenario: As user i cant create new todos by blank title body json
    Given   Create todos by user id 6810624 and valid json "invalidTodos.json"
    When    Send request create todos
    Then    Status code should be 422