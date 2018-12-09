package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HomePage;
import framework.web_pages.LoginPage;
import org.testng.Assert;
import util.ConfigReader;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|mobile number|new password) text fields on home screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail(anyText);
                break;
            case "password":
                homePage.enterPassword(anyText);
                break;
            case "firstname":
                homePage.enterFirstName(anyText);
                break;
            case "lastname":
                homePage.enterLastName(anyText);
                break;
            case "mobile number":
                homePage.enterMobileNumber(anyText);
                break;
            case "new password":
                homePage.enterNewPassword(anyText);
                break;
        }
    }

    @When("^I click on (login|create account) button on home screen$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "create account":
                //Implement Create account object
                break;
        }
    }

    @Then("^I verify that i am an invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log into Facebook");
    }

    @Then("^I see number [0-9]* in text field$")
    public void textField(int num) {

    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }
}
