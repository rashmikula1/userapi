
@tag
Feature: Get All users
  

Background: 
 Given User sets basic Authorization 
  
  @tag1
  Scenario: Check if user able to retrieve all users with valid endpoint
  
    Given User creates GET Request 
    When User sends HTTPS Request 
    Then User receives 200 Status with response body 

   

  @tag2
  Scenario: Check if user able to retrieve all users with invalid endpoint
    Given User creates GET Request 
    When User sends HTTPS Request for the user  invalid API endpoint
    Then User receives a 404 status with the response body

   