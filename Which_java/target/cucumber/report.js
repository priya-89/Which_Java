$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Which/sololo.feature");
formatter.feature({
  "line": 3,
  "name": "As a user searchin",
  "description": "",
  "id": "as-a-user-searchin",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@solo"
    }
  ]
});
formatter.before({
  "duration": 2448761488,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "Enter the Which Television Landing page",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I navigate to Televisions webpage",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I wait for the page load",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I assert the page as Which Television webpage",
  "keyword": "And "
});
formatter.match({
  "location": "whichTele.i_navigate_to_Televisions_webpage()"
});
formatter.result({
  "duration": 3449094005,
  "status": "passed"
});
formatter.match({
  "location": "whichTele.i_wait_for_the_page_load()"
});
formatter.result({
  "duration": 999985895,
  "status": "passed"
});
formatter.match({
  "location": "whichTele.i_assert_the_page_as_Which_Television_webpage()"
});
formatter.result({
  "duration": 7394718,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Search for an item from Television page",
  "description": "",
  "id": "as-a-user-searchin;search-for-an-item-from-television-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "I search for televsions from search textbox",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I should navigate to a television product list page",
  "keyword": "Then "
});
formatter.match({
  "location": "whichTele.iSearchForTelevsionsFromSearchTextbox()"
});
formatter.result({
  "duration": 1540887458,
  "status": "passed"
});
formatter.match({
  "location": "whichTele.iShouldNavigateToATelevisionProductListPage()"
});
formatter.result({
  "duration": 151981193,
  "status": "passed"
});
formatter.after({
  "duration": 1137248174,
  "status": "passed"
});
});