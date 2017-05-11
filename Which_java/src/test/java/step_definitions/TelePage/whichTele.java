package step_definitions.TelePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import step_definitions.support.SeleniumBase;

public class whichTele {

    SeleniumBase sb = new SeleniumBase();

    @Given("^I navigate to Televisions webpage$")
    public void i_navigate_to_Televisions_webpage() throws Throwable {

        sb.navigate("whichLandingURL");
        sb.assertUrl("whichLandingURL");
    }

    @Then("^I wait for the page load$")
    public void i_wait_for_the_page_load() throws Throwable {

        sb.WaitASecond();
    }

    @Then("^I assert the page as Which Television webpage$")
    public void i_assert_the_page_as_Which_Television_webpage() throws Throwable {
        sb.assertUrl("whichLandingURL");

    }

    @When("^I sort by Most-recently tested$")
    public void iSortByMostRecentlyTested() throws Throwable {


    }

    @Then("^Page should populate with preferred items and I  http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=testing_date_desc&page=(\\d+) each sorted dropdown$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyTesting_date_descPageEachSortedDropdown(int arg1) throws Throwable {

    }

    @When("^I sort by Price \\(low to high\\)$")
    public void iSortByPriceLowToHigh() throws Throwable {


    }

    @Then("^Page should populate with preferred items and I  http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=price_asc&page=(\\d+) each sorted dropdown$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyPrice_ascPageEachSortedDropdown(int arg1) throws Throwable {

    }

    @When("^I sort by Price \\(high to low\\)$")
    public void iSortByPriceHighToLow() throws Throwable {

    }

    @Then("^Page should populate with preferred items and I  http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=price_desc&page=(\\d+) each sorted dropdown$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyPrice_descPageEachSortedDropdown(int arg1) throws Throwable {

    }

    @When("^I Filter by (\\d+)-(\\d+)$")
    public void iFilterBy(int arg1, int arg2) throws Throwable {

        if(arg1 == 17)
        {
           sb.radio("check17-22");
           Thread.sleep(5000);
        }else if(arg1 == 24) {
            sb.radio("check24-32");
            Thread.sleep(5000);
        }else if(arg1 == 39) {
            sb.radio("check39-46");
            Thread.sleep(5000);
        }else if(arg1 == 47) {
            sb.radio("check47-50");
            Thread.sleep(5000);
        }else if(arg1 == 51) {
            sb.radio("check51-55");
            Thread.sleep(5000);
        }else if(arg1 == 60) {
            sb.radio("check60-65");
            Thread.sleep(5000);
        }else
            System.out.println("No such checkbox available");
    }


    @Then("^Page should populate with preferred items and I  http://www\\.which\\.co\\.uk/reviews/televisions\\?search\\[range\\]\\[screen_size\\]\\[Screen_size\\]\\[\\]=(\\d+)-(\\d+)&sortby=testing_date_desc&page=(\\d+) each Filtered page$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSearchRangeScreen_sizeScreen_sizeSortbyTesting_date_descPageEachFilteredPage(int arg1, int arg2, int arg3) throws Throwable {
        if(arg1 == 17)
        {
            sb.assertUrl("filter17-22");
        }else if(arg1 == 24)
        {
            sb.assertUrl("filter24-32");
        }else if(arg1 == 39)
        {
            sb.assertUrl("filter39-46");
        }else if (arg1 == 47)
        {
            sb.assertUrl("filter47-50");
        }
        else if (arg1 == 51)
        {
            sb.assertUrl("filter51-55");
        }else if (arg1 == 60)
        {
            sb.assertUrl("filter60-65");
        }
    }

    @When("^I sort byMost-recentlytested$")
    public void iSortByMostRecentlytested() throws Throwable {

        sb.Selectdrpdown("dropdown","testing_date_desc");
        Thread.sleep(5000);
    }

    @Then("^Page should populate with preferred items and I http://www\\.which\\.co\\.uk/reviews/televisions each sorted page$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsEachSortedPage() throws Throwable {

        sb.assertUrl("whichLandingURL");
    }

    @When("^I sort byPrice\\(lowtohigh\\)$")
    public void iSortByPriceLowtohigh() throws Throwable {

        sb.Selectdrpdown("dropdown","price_asc");
        Thread.sleep(5000);
    }

    @Then("^Page should populate with preferred items and I http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=price_asc&page=(\\d+) each sorted page$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyPrice_ascPageEachSortedPage(int arg1) throws Throwable {

        sb.assertUrl("priceLowtoHigh");
    }

    @When("^I sort byPrice\\(hightolow\\)$")
    public void iSortByPriceHightolow() throws Throwable {

        sb.Selectdrpdown("dropdown","price_desc");
        Thread.sleep(5000);
    }

    @Then("^Page should populate with preferred items and I http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=price_desc&page=(\\d+) each sorted page$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyPrice_descPageEachSortedPage(int arg1) throws Throwable {

        sb.assertUrl("priceHightoLow");
    }



    @When("^I sort byScreen size\\(high to low\\)$")
    public void iSortByScreenSizeHighToLow() throws Throwable {

        sb.Selectdrpdown("dropdown","screen_size_desc");
        Thread.sleep(5000);
    }

    @Then("^Page should populate with preferred items and I http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=screen_size_desc&page=(\\d+) each sorted page$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyScreen_size_descPageEachSortedPage(int arg1) throws Throwable {

        sb.assertUrl("screensizeHightoLow");
    }

    @When("^I sort byMost-recently launched$")
    public void iSortByMostRecentlyLaunched() throws Throwable {

        sb.Selectdrpdown("dropdown","launch_date_desc");
        Thread.sleep(5000);

    }

    @Then("^Page should populate with preferred items and I http://www\\.which\\.co\\.uk/reviews/televisions\\?sortby=launch_date_desc&page=(\\d+) each sorted page$")
    public void pageShouldPopulateWithPreferredItemsAndIHttpWwwWhichCoUkReviewsTelevisionsSortbyLaunch_date_descPageEachSortedPage(int arg1) throws Throwable {

        sb.assertUrl("MostRecentlyLaunched");
    }



    @Then("^I click on the maxiumum page options available and i ensure i assert that i navigated to correct page$")
    public void i_click_on_the_maxiumum_page_options_available_and_i_ensure_i_assert_that_i_navigated_to_correct_page() throws Throwable {
        sb.paginate("paginate2","Page2");
        sb.paginate("paginate3","Page3");
        sb.paginate("paginate4","Page4");
        sb.paginate("paginate5","Page5");
        sb.paginate("paginate6","Page6");
        sb.paginate("paginate7","Page7");
        sb.paginate("paginate8","Page8");
        sb.paginate("paginate9","Page9");
    }

    @When("^I Filter a John Lewis$")
    public void i_Filter_a_John_Lewis() throws Throwable {

        sb.radio("JohnLewis");
        Thread.sleep(10000);

    }

    @Then("^I assert the url(\\d+) after applying filter$")
    public void iAssertTheUrlAfterApplyingFilter(int arg1) throws Throwable {

        sb.assertUrl("filterURL");
    }

    @Then("^I clear the filters$")
    public void i_clear_the_filters() throws Throwable {

        sb.click("clearAll");
        Thread.sleep(2000);
       sb.assertUrl("screensizeHightoLow");
       Thread.sleep(2000);
    }

    @Then("^I Filter by (\\d+)-inch$")
    public void iFilterByInch(int arg1) throws Throwable {

        sb.radio("50inch");
        Thread.sleep(10000);

    }


    @When("^I search for televsions from search textbox$")
    public void iSearchForTelevsionsFromSearchTextbox() throws Throwable {

        sb.click("Search");
        sb.textBoxInput("SendtoSearch","searchtext");
        sb.click("clickSearch");



    }

    @Then("^I should navigate to a television product list page$")
    public void iShouldNavigateToATelevisionProductListPage() throws Throwable {
        sb.assertUrl("searchTVURL");

    }

}

