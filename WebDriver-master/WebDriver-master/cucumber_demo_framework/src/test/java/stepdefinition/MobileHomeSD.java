package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobile_pages.HomePage;
import org.testng.Assert;

public class MobileHomeSD {
    HomePage homePage = new HomePage();

//FA2-116
//Given I am on a home page of the app
//When I click on filter button
//And I disable "Angular" option
//And I click on All Reset Filer button
//Then I verify all options are enabled

    @Given("^I am on a home page of the app$")
    public void iAmOnHomePage() {
        Assert.assertTrue(homePage.verifyIconDisplayed());
    }

    @When("^I click on filter button$")
    public void clickOnFilterButton() throws InterruptedException {
        homePage.clickOnButton();
    }

    @And("^I disable Angular option$")
    public void disableOption() throws InterruptedException {
        homePage.disableOption();
    }

    @And("^I click on All Reset Filer button$")
    public void clickOnAllResetButton() throws InterruptedException {
        homePage.clickOnAllResetButton();
    }

    @Then("^I verify all options are enabled$")
    public void verifyAllOptionSelected(){
        Assert.assertTrue(homePage.verifyAllOptionsSelected());
    }

    //FA2-107
    //Scenario: Verify user should be able to slide right on tutorial pages
    //Given I am on Splash screen of the ionic conference app
    //When I swipe right 3 times on tutorials slides
    //Then I verify Continue button is displayed

    @When("^I swipe right (.+) times on tutorials slides$")
    public void swipeTutorialSlides(int num) throws InterruptedException {
        homePage.swipeTutorialslides(num);
    }

    @Then("^I verify Continue button is displayed$")
    public void continueIsDisplayed(){
        Assert.assertTrue(homePage.continueButtonIsDisplayed());
    }
}