@dealx
Feature: Assessment

  Scenario Outline: TC1
    Given i am on the landing page
    And Search for "<dress>"
    Then Verify that the correct results are diplayed for "<dress>"
    Examples:
      | dress                 |
      | Printed Chiffon Dress |

  Scenario Outline: TC2
    Given i am on the landing page
    And Search for "<dress>"
    Then Verify that the correct results are diplayed for "<dress>" on TC2
    Examples:
      | dress                 |
      | dress,t-shirt, belt |

  Scenario: TC3
    Given i am on the landing page
    And Search for product
    Then Verify that the correct results are diplayed for product


  Scenario Outline: TC4
    Given i am on the landing page
    And login into the application using "<username>" and "<password>"

    Examples:
      | username     | password     |
      |phill@gmail.com | Pa55word |

  Scenario: TC5
    Given i am on the landing page
    And adding to cart and processing

  Scenario: TC6
    Given i am on the landing page
    And adding generic test case