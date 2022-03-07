Feature: Test the search filter

  Scenario Outline: I want to find TV by parameters
    Given I go to the "https://www.onliner.by"
    When I open the "Каталог" page
    And I select the catalog menu "Электроника", catalog submenu "Телевидение и видео" and select "Телевизоры"
    And I select brand as "<brand>"
    And I set the maximum price as "<price>"
    And I set the minimum "<min>" and maximum "<max>" diagonal
    And I set the screen resolution as "<resolution>"
    Then I see the list of found items that matches "<brand>", "<resolution>", "<min>" and "<max>" diagonal, "<resolution>" and "<price>"

    Examples:
      | brand   | price | min | max | resolution          | price |
      | Samsung | 1500  | 40" | 50" | 1920x1080 (Full HD) | 1500  |