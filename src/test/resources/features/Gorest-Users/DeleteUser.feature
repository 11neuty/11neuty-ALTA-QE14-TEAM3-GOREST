Feature: Reqres Delete User
  As a user i want to delete reqres user

  @Project
  #Positive
  Scenario Outline: Delete user with valid parameter user id
    Given Delete single user with valid user id <id>
    When Send request delete single user
    Then Status code should be 204

    Examples:
      | id      |
      | 6812801 |
      | 6812802 |

  @Project
  #Negative
  Scenario Outline: Delete user with invalid parameter user id
    Given Delete single user with invalid user id <id>
    When Send request delete single user
    Then Status code should be 404

    Examples:
      | id   |
      | -1   |
      | 1000 |
      | 23   |