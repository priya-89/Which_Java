@solo

Feature: As a user searchin

  Background: Enter the Which Television Landing page

    Given I navigate to Televisions webpage
    Then  I wait for the page load
    And  I assert the page as Which Television webpage




    Scenario: Search for an item from Television page

      When I search for televsions from search textbox
      Then I should navigate to a television product list page
