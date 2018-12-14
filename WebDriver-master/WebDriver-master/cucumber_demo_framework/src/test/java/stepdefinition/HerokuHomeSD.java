package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HerokuHome;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HerokuHomeSD {
    private HerokuHome herokuhome = new HerokuHome();
    private SoftAssert softAssert = new SoftAssert();

    //FA2-181
//    Given I am on home page
//    When I search on top search bar with text "ios"
//    Then I verify "TItle: I will teach you IOS" as displayed result

    @Given("^I am on Heroku home page$")
    public void iAmOnHerokuHomepage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Threely Starter Template", "Invalid Page");
    }

    @When("^I search on top search bar with text (.+)$")
    public void searchHeroku(String input) throws InterruptedException {
        herokuhome.searchHeroku(input);
    }

    @Then("^I verify (.+) as displayed result$")
    public void verifyTitle(String message) {
        Assert.assertEquals(herokuhome.verifyTitle(), message, "Search Result does not match to \"Title: I will teach you IOS\"");
    }

    //FA2-30
//    Given I am on home page of Heroku
//    Then I verify 94 total post is displayed
//    And I verify all post has price tag
//    And I verify all post has title
//    And  I verify all post has displayed image

    @Then("^I verify (.+) total post is displayed$")
    public void verifyNumPosts(int num){
        try {
            softAssert.assertEquals(herokuhome.verifyNumPosts(), num);
        } catch (Exception e) {
            softAssert.assertAll();
            e.printStackTrace();
        }
    }

    @And("^I verify (.+) post has price tag$")
    public void verifyPostsWithPrice(int num){
        try {
            softAssert.assertEquals(herokuhome.verifyPostsWithPrice(), num,"Not all posts have price");
        } catch (Exception e) {
            softAssert.assertAll();
            e.printStackTrace();
        }
    }

    @And("^I verify (.+) post has title$")
    public void verifyPostsHaveTitle(int num){
        try {
            softAssert.assertEquals(herokuhome.verifyPostsHaveTitle(), num, "Not all posts have title");
        } catch (Exception e) {
            softAssert.assertAll();

        }
    }

    @And("^I verify (.+) post has displayed image$")
    public void verifyPostsHaveImage(int num){
        try {
            softAssert.assertEquals(herokuhome.verifyPostsHaveImage(), num, "Not all posts have images");
            //SoftAssert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            softAssert.assertAll();
        }

    }
}
