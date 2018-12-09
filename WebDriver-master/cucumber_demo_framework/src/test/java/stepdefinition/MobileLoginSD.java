package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobile_pages.LandingPage;
import framework.mobile_pages.LoginPage;
import org.testng.Assert;


public class MobileLoginSD {

    LandingPage landingPage = new LandingPage();

    @When("^I click on skip button")
    public void clickOnSkipButton() {
        landingPage.tapOnSkipButton();
    }

    @When("^I click on menu button$")
    public void clickOnMenuButton() throws InterruptedException {
        Thread.sleep(30000);
        landingPage.tapOnMainMenuButton();
    }

    @Then("^I verify sidebar menu is displayed$")
    public void verifySidebarMenu() {
        Assert.assertTrue(landingPage.isSideMenuBarDisplayed());
    }

    @When("^I click on favorites button$")
    public void iClickOnFavoritesButton() throws InterruptedException {
        Thread.sleep(30000);
        landingPage.iClickOnFavoritesButton();
    }

    @Then("^I verify No Sessions Found text displayed$")
    public void iVerifyTextDisplayed(){
        Assert.assertTrue(landingPage.iVerifyTextDisplayed());
    }



}
