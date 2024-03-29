@Comment
  Feature:

    Scenario: Create comments with valid json
      Given Create comments with valid json "CreateCommentValid.json"
      When Send request create new comment
      Then Status code should be 201
      And Validate Json Schema "CreateCommentJsonSchema.json"

    Scenario: Create comments with unregistered id
      Given Create comments with valid json "CreateCommentUnregistered.json"
      When Send request create new comment
      Then Status code should be 404
      And Validate Json Schema "CreateCommentJsonSchema.json"
