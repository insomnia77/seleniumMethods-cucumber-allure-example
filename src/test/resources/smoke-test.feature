#language: en
Feature: test
Background:
When log in with username "Luke" and password "Skywalker"

@smoke
  Scenario Outline: Smoke
    When add employee with first name "<first_name>" and last name "<last_name>" and start date "<start_date>" and email "<email>"

  Examples:
      | first_name | last_name | start_date   | email   |
      | Johnnie    | Walker    | 2017-11-11   | test@mmmamail.ru    |
