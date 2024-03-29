Feature: Create new posts

  @Project
  Scenario Outline:Create new posts with valid body
    Given Set request create body "<reqBody>" as body and <id> as id
    When Send request create posts
    Then API should return response 201
    And Validate json schema "CreatePostsValidBodyJsonSchema.json"
    Examples:
      | reqBody                   | id      |
      | CreatePostsValidBody.json | 6806721 |

  @Project
  Scenario Outline: Create new posts with invalid  title and body
    Given Set request create body "<reqBody>" as body and <id> as id
    When Send request create posts
    Then API should return response 422
    Examples:
      | reqBody                      | id      |
      | CreatePostsInvalidBody1.json | 6806721 |
      | CreatePostsInvalidBody2.json | 6806721 |
      | CreatePostsInvalidBody3.json | 6806721 |