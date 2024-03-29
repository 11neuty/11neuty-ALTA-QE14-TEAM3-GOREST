Feature: Gorest Get User
  As a user i want to create new user

  @Project
  #Positive-TC1
  Scenario Outline: Create new user with valid body json
    Given Create new user with valid body json "<json>"
    When Send request post user
    Then Status code should be 201
    And Response body data name should be "<name>" and email "<email>"
    And Validate json schema "CreateUserJsonSchema.json"

    Examples:
      | json             | name    | email             |
      | CreateUser1.json | Alicia  | alicia@gmail.com  |
      | CreateUser2.json | Patrick | patrick@gmail.com |

  @Project
  #Negative-TC1
  Scenario Outline: Create new use with invalid body json
    Given Create new user with invalid body json "<json>"
    When Send request post user
    Then Status code should be 422

    Examples:
      | json                    |
      | CreateUserInvalid1.json |
      | CreateUserInvalid2.json |

