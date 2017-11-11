#language: en
Feature: test
Background:
Given log in with username "Luke" and password "Skywalker"

@smoke
  Scenario Outline: Add employees
    When add employee with first name "<first_name>" and last name "<last_name>" and start date "<start_date>" and email "<email>"
    Then employee with first name "<first_name>" and last name "<last_name>" is present

  Examples:
      | first_name | last_name | start_date   | email   |
      | Johnnie    | Walker    | 2017-11-11   | test@mmmamail.ru    |
      | Ivan       | Ivanov    | 2016-09-11   | double_test@mmmagmail.com    |

Scenario Outline: Edit employees
    When select employee with first name "<selected_first_name>" and last name "<selected_last_name>"
    And edit selected employee and set first name "<first_name>" and set last name "<last_name>" and set start date "<start_date>" and set email "<email>"
    Then employee with first name "<first_name>" and last name "<last_name>" is present

     Examples:
          | selected_first_name | selected_last_name | first_name | last_name     | start_date    | email   |
          | Johnnie             | Walker             | Mark       | Zuckerberg    | 2014-11-11    | test@myahoo.com    |
          | Ivan                | Ivanov             | Bill       | Gates         | 2016-09-11    | double_test@mmmayahoo.com    |

Scenario Outline: Delete employees
    When select employee with first name "<selected_first_name>" and last name "<selected_last_name>"
    And delete selected employee
    And logout

     Examples:
          | selected_first_name | selected_last_name |
          | Mark                | Zuckerberg         |
          | Bill                | Gates              |