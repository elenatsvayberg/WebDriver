package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BasePage;
import framework.web_pages.Darksky;
import org.testng.Assert;

public class DarkskySD {
   private Darksky darksky = new Darksky();

    @Given("^I am on Darksky website homepage$")
    public void iAmOnDarkskyWebsiteHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - 260 Broadway, New York City, NY", "Invalid Page");
    }


    @When("^I clear search field$")
    public void clearField() {
        darksky.clearField();
    }

    @When("^I enter (.+) into the search field$")
    public void sendText(String input) throws InterruptedException {
        darksky.sendText(input);
    }

    @When("^I click on search magnifying glass$")
    public void clickOnSearch() throws InterruptedException {
        darksky.clickOnSearch();
    }

    @Then("^I verify current temperature is between low and high value$")
    public void verifyTemperature() throws InterruptedException {
        darksky.verifyTemperature();
    }

//FA2-152
//    Scenario: Verify timline is displayed in correct format
//    Given I am on Darksky home page
//    Then I verify timeline is displayed with two hours incremented

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline() throws InterruptedException {
        darksky.verifyTimeline();
    }


//FA2-90
//    Scenario: Verify individual day temp timeline
//    Given I am on Darksky Home Page
//    When I expand todays timeline
//    Then I verify lowest and highest temp is displayed correctly

    @When("^I expand todays timeline$")
    public void expandTodaysTimeLine () throws InterruptedException {
        darksky.expandTodaysTimeLine();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLowHighTemp(){
        darksky.verifyLowHighTemp();
    }

    //FA2-73
//    Scenario: Verify Time Machine Calendar
//    Given I am on Darksky home page
//    When I click on Time Machine
//    Then I verify date is selected to todays date

    @When("^I click on Time Machine$")
    public void clickOnTimeMachine() throws InterruptedException {
        darksky.clickOnTimeMachine();
    }

    @Then("^I verify date is selected to todays date$")
    public void verifyTodayIsSelected(){
        Assert.assertEquals(darksky.verifyTodayIsSelected(), darksky.todayDate(), "Today is not equal to calendar's highlighted day");
    }


}
