#language: en
Feature: test
Background:
When log in with username "Luke" and password "Skywalker"

@smoke
  Scenario: Smoke
    When log in with username "Luke" and password "Skywalker"

