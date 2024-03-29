Feature: Get user posts

  @Project
  Scenario Outline: Get list user posts with valid parameter
    Given Set parameter with id <id>
    When Send request get list user posts
    Then API should return response 200
    And Validate json schema "ListUserPostsValidParameterJsonSchema.json"
    Examples:
      | id      |
      | 6806721 |

  @Project
  Scenario Outline: Get list user posts with invalid parameter
    Given Set parameter with id "<invalid id>"
    When Send request get list user posts
    Then API should return response 404
    And Validate json schema "ListUserPostsInvalidParameterJsonSchema.json"
    Examples:
      | invalid id |
      | qwerty     |
      | !@#$%      |
      |            |

  @Project
  Scenario: Get users posts without parameter
    Given Set path without parameter
    When Send request get list user posts without parameter
    Then API should return response 200
    And Validate json schema "ListUserPostsWithoutParameterJsonSchema.json"