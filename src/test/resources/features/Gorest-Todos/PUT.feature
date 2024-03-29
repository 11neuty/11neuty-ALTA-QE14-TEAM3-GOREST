Feature: Put todos
  As user i can update todos by valid id and cant update todos by invalid id

  @Project
  Scenario Outline: As user i can update todos by valid id and json body request
    Given Update todos with id <id> and json <json>
    When Send request to update todos
    Then Status code should be <statusCode>
    And Response body id should be <id>
    And Validate json schema <json1>
    Examples:
      | id    | json               | statusCode | json1                |
      | 46628 | "validUpdate.json" | 200        | "PutJsonSchema.json" |
      | 46645 | "validUpdate.json" | 200        | "PutJsonSchema.json" |

  @Project
  #Negative test case
  Scenario Outline: As user i cant update todos by invalid json body request
    Given Update todos with id <id> and json <json>
    When Send request to update todos
    Then Status code should be <statusCode>
    Examples:
      | id    | json                 | statusCode |
      | 46628 | "invalidUpdate.json" | 422        |
      | 46645 | "invalidUpdate.json" | 422        |

  @Project
  Scenario Outline: As user i cant update todos by invalid id
    Given Update todos with id <id> and json <json>
    When Send request to update todos
    Then Status code should be <statusCode>
    Examples:
      | id  | json               | statusCode |
      | 465 | "validUpdate.json" | 404        |
      | 99  | "validUpdate.json" | 404        |