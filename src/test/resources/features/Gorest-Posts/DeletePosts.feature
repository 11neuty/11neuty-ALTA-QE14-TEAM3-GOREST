Feature: Delete user posts

  @Project
  Scenario Outline: Delete user post with valid id
    Given Set parameter with <id> as id
    When Send request delete posts
    Then API should return response 204
    Examples:
      | id     |
      | 115863 |

  @Project
  Scenario Outline:
    Given Set parameter with "<id>" as id
    When Send request delete posts with invalid id
    Then API should return response 404
    And Validate json schema "DeletePostsInvalidIdJsonSchema.json"
    Examples:
      | id     |
      | qwerty |
      | !@#$%  |