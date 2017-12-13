$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("problem1.feature");
formatter.feature({
  "line": 2,
  "name": "Test",
  "description": "",
  "id": "test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Test"
    }
  ]
});
formatter.before({
  "duration": 4361953967,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "",
  "description": "",
  "id": "test;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the user is on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the user selects two items to purchase",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the user should see selected two items in the cart",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "the user verifies the price of the item  changes accordingly as you change the quantity",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the user verifies the total price matches the sum of two proces",
  "keyword": "Then "
});
formatter.match({
  "location": "Tests.the_user_is_on_the_home_page()"
});
formatter.result({
  "duration": 1798983099,
  "status": "passed"
});
formatter.match({
  "location": "Tests.the_user_selects_two_items_to_purchase()"
});
formatter.result({
  "duration": 2883827417,
  "status": "passed"
});
formatter.match({
  "location": "Tests.the_user_should_see_selected_two_items_in_the_cart()"
});
formatter.result({
  "duration": 1017947554,
  "status": "passed"
});
formatter.match({
  "location": "Tests.the_user_verifies_the_price_of_the_item_changes_accordingly_as_you_change_the_quantity()"
});
formatter.result({
  "duration": 766605914,
  "status": "passed"
});
formatter.match({
  "location": "Tests.the_user_verifies_the_total_price_matches_the_sum_of_two_proces()"
});
formatter.result({
  "duration": 138384913,
  "status": "passed"
});
formatter.after({
  "duration": 1097680558,
  "status": "passed"
});
});