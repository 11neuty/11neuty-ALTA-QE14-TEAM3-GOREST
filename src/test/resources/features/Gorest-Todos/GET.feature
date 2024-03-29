Feature: GET TODOS
  As user i can get todos by valid id and user id, and cant get todos by invalid id and user id

  @Project
  #POSITIVE TEST CASE
  Scenario: As user i can get all todos
    Given  Get all todos with valid page
    When   Send request get all todos
    Then   Status code should be 200
    And    Response body status should be "completed"
    And    Validate json schema "GetAllTodos.json"

  @Project
  Scenario Outline: As user i can get single user todos by valid id
    Given Get user todos by id <id>
    When Send request get todos by id
    Then Status code should be <statusCode>
    And Response body id should be <id>
    And Validate json schema <json>
    Examples:
      | id    | statusCode | json                        |
      | 46628 | 200        | "GetValidIdJsonSchema.json" |
      | 46647 | 200        | "GetValidIdJsonSchema.json" |

  @Project
  Scenario Outline: As user i can get single user todos by valid user id
    Given Get user todos by user id <userId>
    When Send request get todos by user id
    Then Status code should be <statusCode>
    And Response body user id should be <userId>
    And Validate json schema <json>
    Examples:
      | userId  | statusCode | json                       |
      | 6806879 | 200        | "GetUserIdJsonSchema.json" |
      | 6810726 | 200        | "GetUserIdJsonSchema.json" |

  @Project
  Scenario Outline: As user i can get todos by valid parameter
    Given Get user todos by valid page <page>  per_page <per_page>
    When Send request get todos by parameter
    Then Status code should be <statusCode>
    Examples:
      | page | per_page | statusCode |
      | 10   | 11       | 200        |
      | 15   | 20       | 200        |

  @Project
  #Negative test case
  Scenario Outline: As user i cant get todos by invalid id
    Given Get user todos by id <id>
    When Send request get todos by id
    Then Status code should be <statusCode>
    Examples:
      | id  | statusCode |
      | 465 | 404        |
      | 20  | 404        |

  @Project
  Scenario Outline: As user i cant get todos by unregistered user id
    Given Get user todos by user id <userId>
    When Send request get todos by user id
    Then Status code should be <statusCode>
    Examples:
      | userId | statusCode |
      | 680    | 404        |
      | 68     | 404        |

  @Project
  Scenario: As user i cant get todos by invalid parameter
    Given      Get user todos by valid page -10  per_page 11
    When       Send request get todos by parameter
    Then       Status code should be 404