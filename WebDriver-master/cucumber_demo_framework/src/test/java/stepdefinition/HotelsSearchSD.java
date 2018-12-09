package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HotelLandingPage;

public class HotelsSearchSD {

    private HotelLandingPage landingPage = new HotelLandingPage();

    @When("^I select destination as (.+)$")
    public void selectDestination(String city) throws InterruptedException {
        landingPage.enterDestination(city);
    }

    @When("^I select checking date as (.+) and checkout date as (.+)$")
    public void selectCheckInDate(int checkInDay, int checkOutDay) throws InterruptedException {
        landingPage.selectCheckInDay(checkInDay);
        landingPage.selectCheckOutDay(checkOutDay);
    }

    @When("^I select (.+) from home page$") //More options...
    public void selectMoreOptionsFromRooms(int option) throws InterruptedException{
        landingPage.selectMoreOptionsFromRooms(option);
    }

    @When("^I select (room|adult|children|childone|childtwo) as (.+)$")
    public void selectFromDropdown(String dropdownName, String choice){
        switch (dropdownName){
            case "room":
                landingPage.selectFromDropDownRoom(choice);
                break;
            case "adult":
                landingPage.selectFromDropDownNumAdults(choice);
                break;
            case "children":
                landingPage.selectFromDropDownNumChildren(choice);
                break;
            case "childone":
                landingPage.selectFromDropDownAgeChildOne(choice);
                break;
            case "childtwo":
                landingPage.selectFromDropDownAgeChildTwo(choice);
                break;
        }
    }

//    @When("^I select room as (.+)$")
//    public void selectFromRoomDropDown(String choice) {
//        landingPage.selectFromDropDownRoom(choice);
//    }
//
//   @When("^I select adult as (.+)$")
//   public void selectFromDropDownNumAdults(String choice) {
//       landingPage.selectFromDropDownNumAdults(choice);
//   }
//
//    @When("^I select children as (.+)$")
//    public void selectFromDropDownNumChildren(String choice) {
//        landingPage.selectFromDropDownNumChildren(choice);
//    }
//
//    @When("^I select childone as (.+)$")
//    public void selectFromDropDownAgeChildOne(String choice) {
//        landingPage.selectFromDropDownAgeChildOne(choice);
//    }
//
//    @When("^I select childtwo as (.+)$")
//    public void selectFromDropDownAgeChildTwo(String choice) {
//        landingPage.selectFromDropDownAgeChildTwo(choice);
//    }

    @When("^I click on search button$")
    public void clickOnSearchtButton(){
        landingPage.clickOnSubmitButton();
    }

    @Then("^I verify deal of the day hotel price is between 200 to 300$")
    public void verifyHotelRoomPrice(){
        landingPage.verifyHotelRoomPrice();
    }
}
