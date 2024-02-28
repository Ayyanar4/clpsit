
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 	Background: 
 	Given I landed on ecommerce page

  @Regression
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | Ayan  |     5 | success |
      | XXXX  |     7 | Fail    |
