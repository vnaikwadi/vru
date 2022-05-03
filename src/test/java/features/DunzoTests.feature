#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Dunzo Flows
  I want to use this template for my feature file

  @tag1
  Scenario: Selection of Location
    Given I have navigated to dunzo website at "https://www.dunzo.com/"
    Then Set Location option should be displayed without any location selected
    When I click on Set Location option
    And I provide location as "Indira Nagar"
    Then List of options should appear with "Indira Nagar" as value
    When I Select First Location 
    Then "Indira Nagar" should be displayed in the header section
    

