Feature: Feature to edit details from internal vico profile page and preview them in public Vico Profile Page

  Scenario Outline: Test to edit details from internal vico profile page and preview them in public Vico Profile Page
    Given User visits Profile editing screen
    And user enters <viconame> and <slogan>
    When user visits public vico profile page
    Then edited details should be Updated in public vico profile page.

    Examples: 
      | viconame | slogan  |
      | name     | we will |
