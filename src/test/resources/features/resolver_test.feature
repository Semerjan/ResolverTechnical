Feature: resolver technical assessment

  Background: User is logged into teh application
    Given user open the demo url


  @test1 @Regression
  Scenario: Test sample email log in in Test 1

    Then validate that log in fields  are displayed
    Then Enter a value in the fields


  @test2  @Regression
  Scenario:Validate list group related items in Test 2

    Then validate the list group items


  @test3  @Regression
  Scenario: Validate the options in Test 3

    Then validates the default value of the dropdown
    Then Selects the "Option 3" from the select list


  @test4  @Regression
  Scenario: Validate the buttons in Test 4

    Then Validate the status of buttons


  @test5  @Regression
  Scenario: Validate the appearance and disappearance of a button in Test 5

    Then Validate that button is displayed

  @test6  @Regression
  Scenario: Validate the table data in Test 6

    Then Validate the cell data