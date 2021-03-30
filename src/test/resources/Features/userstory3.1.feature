Feature: Feature to access public Vico Profile Page

  Scenario Outline: Test to access Public Vico Profile page from internal Vico profile page.
    Given Browser is open and user is taken to internal vico login page
    And User enters <email> and <password> and logged in to the application.
    And User visits profile tab.
    When User click on link to access public vico profile page under vico name
    Then Public vico profile page is displayed in a new tab also vico details are displayed.

    Examples: 
      | email                | password     |
      | meeraagney@gmail.com | Reaction123* |
