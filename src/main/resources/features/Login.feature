@smoke
Feature: Login | users could use login functionality to use their accounts

  #Scenario 1
  Scenario:(P1) Verify that user can successfully navigate to the login
    Given User Navigate to login pop-up
    Then User make sure that the current section is the login section

  #Scenario 2
  Scenario:(P2) Verify that user can login with valid phone number and password
    Given User Navigate to login pop-up
    And user enter mobile number "01003803007" and password "Eyad123@"
    When user press login button
    Then User is logged in and welcome message with the name appears in the top right of the screen


  #Scenario 3
  Scenario:(P3) Verify that user can not login with valid phone number and invalid password
    Given User Navigate to login pop-up
    And user enter mobile number "01003803007" and password "Eyad123@@"
    When user press login button
    Then error message appears about the invalid password

  #Scenario 4
  Scenario:(P4) Verify that user can not login with invalid phone number and valid password
    Given User Navigate to login pop-up
    And user enter mobile number "01003003000" and password "Eyad123@"
    When user press login button
    Then error message appears about the invalid phone number

  #Scenario 5
  Scenario:(P5) Verify that user can not login with invalid phone number and invalid password
    Given User Navigate to login pop-up
    And user enter mobile number "01003003000" and password "Eyad123@@"
    When user press login button
    Then error message appears about the invalid phone number first

    #Scenario 6
  Scenario:(P6) Verify that user can show his own password
    Given User Navigate to login pop-up
    And user enter mobile number "01003003007" and password "Eyad123@"
    When when user press eye icon
    Then the entered password should appears