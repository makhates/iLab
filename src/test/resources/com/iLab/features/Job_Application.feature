
  @regression
    Feature: Job application

      @smokedd
      Scenario Outline: User applies for a preferred position

        Given The user is navigated to the dashboard
        Then User navigates to apply page
        And User applies for a preferred position "<Name>", "<Email>", "<PhoneNumber>"
        Then Excepted error message to upload documents is displayed

        Examples:
          |Name		        |Email	                  |PhoneNumber		            |
          |Phillip          |makhates@gmail.com       |0781619503                   |
          |Hope             |john@yahoo.com           |0820679845                   |