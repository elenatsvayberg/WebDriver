package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HerokuLogin;
import org.testng.Assert;

public class HerokuLoginSD {
    //FA@-63
//    Scenario #1: Verify valid login
//    Given: User is on the Heroku login page
//    When: I enter username as “n12345@test.com” and password as “123456”
//    And I click on submit button
//    Then I verify logout button is displayed

    private HerokuLogin herokulogin = new HerokuLogin();

    @Given("^User is on the Heroku login page$")
    public void UserIsOnHerokuLoginpage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Threely Starter Template", "Invalid Page");
    }

    @When("^I enter username as (.+) and password as (.+)$")
    public void enterCredentials(String username, String password) throws InterruptedException {
        herokulogin.enterCredentials(username, password);
    }

    @And("^I click on submit button$")
    public void submit() throws InterruptedException {
        herokulogin.submit();
    }

//    @Then("^I verify (.+) button is displayed$")
//    public void verifyLogoutButtondisplayed(String Logout){
//        Assert.assertEquals(herokulogin.verifyLogoutButtondisplayed(Logout), Logout,"Wrong option");
//    }
}
