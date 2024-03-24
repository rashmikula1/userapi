
@tag
Feature: Get User by userid
Background: 
 Given User sets basic Authorization 
  
  
  @tag1
  Scenario: Check if the user able to retrieve the user with the valid uerid and valid endpoint
    Given User creates GET Request for user by userid
    When User sends HTTPS Request with  valid userid
    Then User receives 200 status with response body
   
  @tag2
  Scenario Outline: Check if the user able to retrieve the user with the invalid userid and valid endpoint
    Given User creates GET Request for user by userid
    When User sends HTTPS Request  with <invaliduserid>
    Then User receives <errorcode> status with response body

    Examples: 
      | invaliduserid | errorcode |
      | 234 | 404 |
      |     | 401 |
   @tag3
   Scenario: Check if the user able to retrieve the user with the valid userid and invalid endpoint
   Given User creates GET Request 
    When User sends HTTPS Request with  invalid enddpoint
    Then User receives 404 status with response body