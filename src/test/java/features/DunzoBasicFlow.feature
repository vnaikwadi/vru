Feature: Dunzo place order flow feature
@Regression
Scenario: Dunzo place order scenario

Given User is on Home Page "https://www.dunzo.com/"
When Title on Home Page is Dunzo
Then User selected menu
Then User add items
And User places order
#And User adds address
And Verify order is placed successfully

@Smoke
Scenario Outline: Pet Supplies Scenario

Given User is on Home Page "https://www.dunzo.com/"
When User clicks on Pet Supplies
Then User selects "<option>"
Then User selects Puppy Food "<food1>" and "<food2>"

Examples:

|option|food1|food2|
|Doraemon Pet|Himalaya Chicken|Nutrition Chicken|

@UAT
Scenario: Pickup & Drop Scenario

Given User is on Home Page "https://www.dunzo.com/"
When User selects menu option
|menu|
|Pickup & Drop|
Then User selects pickup location and drop point
|Lokhandwala,Kandivali East|Thakur Village,Kandivali East|