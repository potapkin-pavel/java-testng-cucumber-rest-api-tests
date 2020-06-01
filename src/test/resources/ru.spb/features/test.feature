@tag
Feature:

  Scenario: Send get request and get 200 status code
    When I send get method on "http://localhost:3000/posts"
    Then Status code is 200