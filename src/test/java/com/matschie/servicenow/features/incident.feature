Feature: Create new incident record feature

  Background: 
    Given set the base path of the service now incident table

  Scenario Outline: Validate the incident record creation with request body as class object
    When send the post request for the incident service to create one record with <short_description> short description
    And send the post request for the incident service to create record with <description> description
    Then ensure the record successfully create

    Examples: 
      | short_description | description        |
      | RESTAPISEP2024    | Rest API Post call |
