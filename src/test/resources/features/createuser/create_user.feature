Feature: Create User UI

  Scenario Outline: Create user happy path
    Given Sign up now page is loaded
    When User selects account type as "<Type>"
    And Selects country "<Country>"
    Then Inputs in field "First Name" "<First Name>"
    And Inputs in field "Last Name" "<Last Name>"
    And Inputs in field "Email address" "<Email Address>"
    Then Selects mobile phone country as "<Mobile prefix>"
    And Enter mobile phone number "<Mobile Number>"
    Then Enters the captch result
    And Agrees with therms of Use and Privacy policy
    And Selects button Open my free account
    Then Message "Check your mail" is displayed

    Examples:
    | Type       | Country        | First Name | Last Name | Email Address            | Mobile prefix             | Mobile Number |
    | Education  | United Kingdom | Miroslav   | Andonov   | wetransfer_test@gmail.com| Netherlands (Holland) +31 | 12312312321   |
    | Individual | Bulgaria       | Miroslav   | Andonov   | wetransfer_test@gmail.com| Netherlands (Holland) +31 | 12312312321   |


  Scenario: Create user validate error message
    Given Sign up now page is loaded
    And Selects button Open my free account
    Then ToolTip with message "Please enter correct information!" is displayed

  Scenario: Create user validate error colors
    Given Sign up now page is loaded
    And Selects button Open my free account
    Then All required fields have red border color

  Scenario Outline: Verify "<Type>" label text
    Given Sign up now page is loaded
    When User selects account type as "<Type>"
    Then Correct "<Message>" for the given type is displayed

    Examples:
    |Type| Message|
    |Education | If you are a student or parent wanting to make a payment to an Educational Institute or for Accommodation, do not sign up here. Please go to TransferMate Education and sign up there instead.|
    |Individual| Use an 'Individual' account for personal payments (e.g. buying a car / property, moving funds between personal accounts).|
