@Test
Feature: Verify yahoo send mail functionality

  Scenario Outline: To Verify yahoo compose mail with attachment functionality : (TS001)
    Given User open given browser window
    And User naviagte to given yahoo url
    And User enter username and password and do login from login page
    And User click on the mail box link from the homepage
    And User click on the compose button on inbox mail page
    And User enter To receipent email id on compose mail page
    And User enter subject on compose mail page
    And User enter some message in message body on compose mail page
    And User click on attachment button on compose mail page
    And User click on the attach file from computer button on compose mail page
    And User upload any type of file "<FilePath>" on compose mail page 
    ## please provide file path according to system location
    And User click on send button on compose mail page

    Examples: 
      | FilePath                                                                              |
      | C:\\Users\\HP\\Desktop\\Practice workspace\\GmailTest\\src\\main\\resources\\Test.jpg | 
