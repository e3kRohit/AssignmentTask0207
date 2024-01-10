Feature: Incorrect email validation

  @wip
  Scenario: Incorrect email validation
    Given user is on home page
    And user enters credentials for state, zipcode, and purpose
    And user clicks on filter button top left blue button
    And user selects vehicle color
    And user selects the most expensive car
    When user enters invalid email for contact info
    Then verify that invalid email error message has been displayed successfully