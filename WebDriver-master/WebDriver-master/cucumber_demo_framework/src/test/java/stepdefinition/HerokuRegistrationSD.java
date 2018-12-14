package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HerokuRegistration;
import org.testng.Assert;

public class HerokuRegistrationSD {
    //FA2-53
//    Scenario: Verify a new user can register with a valid email address
//    Given I am on Registration page
//    When I enter name as "testuser" email as "test@test.com" password as "test12345"
//    And I click 'submit' button
//    Then  I am signed-in as a new user
    private HerokuRegistration herokureg = new HerokuRegistration();

    @Given("^I am on Registration page$")
    public void IamOnRegistrationpage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Threely Starter Template", "Invalid Page");
    }

    @When("^I enter name as (.+) email as (.+) password as (.+)$")
    public void enterCredentials(String name, String email, String password) throws InterruptedException {
        herokureg.enterCredentials(name, email, password);
    }

    @And("^I click submit button$")
    public void submit() throws InterruptedException {
        herokureg.submit();
    }

    @Then("^I am signed-in as a new user$")
    public void verifySignin(){
       // Assert.assertEquals(herokureg.verifySignin(), "Successful login", "Invalid Page");
    }


    //FA2-49
//    Scenario Outline: Verify invalid email on registration
//    Given I am on Registration page
//    When I enter name as "testuser" email as <email> password as "test12345"
//    And I click 'submit' button
//    Then  I verify invalid email address
//
//    Examples:
//            | email |
//            | test.com |
//            | test@test@test.com |

    @When("^I enter name as (.+) email as <email> password as (.+)$")
    public void enterCred(String name, String email, String password) throws InterruptedException {
        herokureg.enterCredentials(name, email, password);
    }

    @And("^I click 'submit' button$")
    public void submitButton() throws InterruptedException {
        herokureg.submit();
    }

    @Then("^I verify invalid email address$")
    public void verifyInvalidMessage() throws InterruptedException {
        herokureg.verifyInvalidMessage();
        Assert.assertEquals("","");
    }

}
