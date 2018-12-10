package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.web_pages.HotelsHomePage;
import org.testng.Assert;

public class HotelsSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on hotel website homepage$")
    public void iAmOnHotelHomePage() {
        //Assert.assertEquals(hotelsHomePage.getPageHeader(), "Where to?", "Unable to verify hotels homepage");
    }

    @When("^I click on GPS locator button$")
    public void clickOnGps() {
        hotelsHomePage.clickOnGpsButton();
    }
}
