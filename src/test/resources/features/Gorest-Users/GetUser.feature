Feature: Gorest Get User
  As a user i want to get gorest user

  @Project
  #Positive-TC1
  Scenario: Get user without parameter (list user)
    Given Get user without parameter
    When Send request get list user
    Then Status code should be 200

  @Project
  #Positive-TC2
  Scenario Outline: Get list user with valid page parameter
    Given Get list user with valid parameter page <page> and per_page <per_page>
    When Send request get list user by page
    Then Status code should be 200

    Examples:
      | page | per_page |
      | 1    | 20       |
      | 5    | 10       |

  @Project
  #Negative-TC3
  Scenario Outline: Get list user with invalid page parameter
    Given Get list user with invalid parameter page <page> and per_page <per_page>
    When Send request get list user by page
    Then Status code should be 404

    Examples:
      | page | per_page |
      | -1   | 10       |
      | 5    | -20      |
      | 30   | 100      |

  @Project
  #Positive-TC4
  Scenario Outline: Get user with valid parameter id
    Given Get user with valid parameter id <id>
    When Send request get user
    Then Status code should be 200
    And Response body data name should be "<name>" and email "<email>"
    And Validate json schema "GetUserJsonSchema.json"

    Examples:
      | id      | name              | email              |
      | 6807171 | Franklin Richards | richards@gmail.com |
      | 6806721 | Raid Okotnanirda  | tnanirda@gmail.com |

  @Project
  #Negative-TC5
  Scenario Outline: Get user with invalid parameter id
    Given Get user with invalid parameter id <id>
    When Send request get user
    Then Status code should be 404

    Examples:
      | id     |
      | 1      |
      | 123123 |
      | -1     |