Feature: Reqres Update User
  As a user i want to update user using put & patch

  #Put
  @Project
  #Positive
  Scenario Outline: Put update user with valid body
    Given Put update user with valid json "<JSON>" and user id <id>
    When Send request put update user
    Then Status code should be 200
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id      | JSON                |
      | 6807171 | PutUpdateUser1.json |
      | 6806721 | PutUpdateUser2.json |

  @Project
  #Negative
  Scenario Outline: Put update user with invalid body
    Given Update user with invalid JSON "<JSON>" and valid user id <id>
    When Send request put update user
    Then Status code should be 422

    Examples:
      | id      | JSON                       |
      | 6807171 | PutUpdateUserInvalid1.json |
      | 6806721 | PutUpdateUserInvalid1.json |

  #Patch
  @Project
  #Positive-UpdateName
  Scenario Outline: Patch update user with valid body
    Given Patch update user with valid json "<JSON>" and user id <id>
    When Send request patch update user
    Then Status code should be 200
    And Response body data name should be "<name>"
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id      | JSON                  | name     |
      | 6807171 | PatchUpdateUser1.json | Franklin |
      | 6806721 | PatchUpdateUser2.json | Rustami  |

  #Patch
  @Project
  #Positive-UpdateEmail
  Scenario Outline: Patch update user with valid body
    Given Patch update user with valid json "<JSON>" and user id <id>
    When Send request patch update user
    Then Status code should be 200
    And Response body data email should be "<email>"
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id      | JSON                  | email                 |
      | 6807171 | PatchUpdateUser3.json | richards@franklin.com |
      | 6806721 | PatchUpdateUser4.json | rustami@rustam.com    |

  @Project
  #Negative
  Scenario Outline: Patch update user with invalid body
    Given Update user with invalid JSON "<JSON>" and valid user id <id>
    When Send request patch update user
    Then Status code should be 422

    Examples:
      | id      | JSON                         |
      | 6807171 | PatchUpdateUserInvalid1.json |
      | 6806721 | PatchUpdateUserInvalid1.json |