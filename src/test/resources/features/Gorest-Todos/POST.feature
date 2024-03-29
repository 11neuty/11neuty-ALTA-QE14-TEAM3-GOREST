Feature: Post todos
  As user i can post todos by valid user id and cant create post by invalid user id

  @Project
  Scenario Outline: As user i can post todos by valid user id
    Given Create todos by user id <userId> and valid json <json>
    When Send request create todos
    Then Status code should be <statusCode>
    And Response body user id post should be <userId>
    And Validate json schema <json1>
    Examples:
      | userId  | json              | statusCode | json1                 |
      | 6810624 | "validTodos.json" | 201        | "PostJsonSchema.json" |
      | 6810726 | "validTodos.json" | 201        | "PostJsonSchema.json" |

  @Project
  #Test case negative
  Scenario Outline: As user i cant create new todos by blank title body json
    Given Create todos by user id <userId> and valid json <json>
    When Send request create todos
    Then Status code should be <statusCode>
    Examples:
      | userId  | json                | statusCode |
      | 6810624 | "invalidTodos.json" | 422        |
      | 6810726 | "invalidTodos.json" | 422        |