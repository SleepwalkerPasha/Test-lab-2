Feature: calculator calculates
  Scenario: Calculate plus
    Given expression is 1.0 "+" 2.0
    When calculate is pressed
    Then displays 3.0

  Scenario: Calculate minus
    Given expression is 6.0 "-" 2.0
    When calculate is pressed
    Then displays 4.0

  Scenario: Calculate divide
    Given expression is 1.0 "/" 2.0
    When calculate is pressed
    Then displays 0.5

  Scenario: Calculate multiply
    Given expression is 10.0 "*" 2.0
    When calculate is pressed
    Then displays 20.0

  Scenario: Calculate divide with 0
    Given expression is 1.0 "/" 0.0
    When calculate is pressed
    Then displays error "Cannot calculate result"