Feature: Update user posts
  Scenario Outline: Update user posts with valid id and body
    Given Set request body "<body>" as body and <id> as id
    When Send request update post
    Then API should return response 200
    And Validate json schema "UpdatePostsValidIdJsonSchema.json"
    Examples:
      | body                      | id     |  |
      | UpdatePostsValidBody.json | 115818 |  |

  Scenario Outline: Update user posts with invalid id
    Given Set request body "<reqbody>" as body and "<id>" as id
    When Send request update post
    Then API should return response 404
    And Validate json schema "UpdatePostsInvalidIdJsonSchema.json"
    Examples:
      | reqbody                   | id     |
      | UpdatePostsValidBody.json | qwerty |
      | UpdatePostsValidBody.json | !@#$%  |