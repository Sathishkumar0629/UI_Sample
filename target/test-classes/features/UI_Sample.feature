Feature: Sample Automation Store

  Scenario Outline: UI Sample test
    Given launch automation store test site
    And click on login or register link
    And click on continue button
    And enter given "<FirstName>" "<LastName>" and "<EMail>" details
    And enter given address details "<Address1>" "<City>"
    And enter "<ZIPcode>"
    And select country and select region
    And enter login details "<LName>" "<Pwd>" "<Cpwd>"
    And select privacy policy checkbox
    When click on continue button after filling all the required details
    Then verifies account created page with name
    And click on cart
    And click on continue button for shopping
    And add product to the cart
    And proceed to checkout page
    And verifies confirmation page
    And close browser

    Examples: 
      | FirstName      | LastName | EMail                      | Address1   | City   | ZIPcode | LName            | Pwd               | Cpwd              |
      | kumarnkskkkkkk | sameshkk | kkkkkkgaamesh123@gmail.com | rav street | mumbai |  456378 | kkkkkkasureshjkt | kkkkkkaguresh@123 | kkkkkkaguresh@123 |
