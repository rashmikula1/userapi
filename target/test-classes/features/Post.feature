@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given User sets basic Authorization

  @tag1 @regression
  Scenario: Check User able to create new userID with valid data
    Given User able to create new User with fields from "post" with "validpost"
    When user calls "CreateUserAPI" with "POST" http request
    Then the API call got success with status code 201
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify user  "GetuseridAPI" using "GET"

  @tag2 @regression
  Scenario: Verify if get all user functionality is working
    Given User able to get all User
    When user calls "GetUserAPI" with "GET" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

  @tag3 @regression
  Scenario: Verify if get user by name functionality is working
    Given User able to get  User by name
    When user calls "GetUserNameAPI" with "GET" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

  @tag4 @regression
  Scenario: Verify if update user functionality is working
    Given User able to update new User
    When user calls "UpdateUserAPI" with "PUT" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And verify user  "GetuseridAPI" using "GET"

  @Delete @regression
  Scenario: Verify if Delete user functionality is working
    Given User able to delete new User
    When user calls "DeleteUserAPI" with "DELETE" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And verify user  "GetuseridAPI" using "GET"
