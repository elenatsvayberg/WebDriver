package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotelLandingPage extends BasePage {

    private By destinationTextField = By.id("qf-0q-destination");
    private By closeLink = By.xpath("//button[@class='cta cta-link']");
    //By.xpath("//h1[@class='cont-hd-alt widget-query-heading']");
    private By calendarPicker = By.xpath(".//*[@class='widget-datepicker-bd']//descendant::a");
    private By checkInField = By.xpath(".//*[@id='qf-0q-localised-check-in']");
    private By checkOutField = By.xpath(".//*[@id='qf-0q-localised-check-out']");
    private By moreOptions = By.cssSelector("#qf-0q-compact-occupancy");
    private By dropDownLocatorRoom = By.id("qf-0q-rooms");
    private By dropDownLocatorNumAdults = By.id("qf-0q-room-0-adults");
    private By dropDownLocatorNumChildren = By.id("qf-0q-room-0-children");
    private By dropDownLocatorAgeChild1 = By.id("qf-0q-room-0-child-0-age"); //2
    private By dropDownLocatorAgeChild2 = By.id("qf-0q-room-0-child-1-age"); //3
    private By searchButton = By.xpath("//button[@type='submit']");
    private By pricePromo = By.xpath(".//*[@class='hotel deal-of-the-day']//ins");

    @Step
    public void enterDestination(String city) throws InterruptedException {
        sendText(destinationTextField, city);
        Thread.sleep(1000);
        clickOn(closeLink);
    }

    @Step
    public void selectCheckInDay(int checkInDays) throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, checkInDays);
        Date expectedDay = c.getTime();
        String expectedDayFormat = sdf.format(expectedDay);

        clickOn(checkInField);
        Thread.sleep(1000);
        List<WebElement> days = SharedSD.getDriver().findElements(calendarPicker);

        for (WebElement day : days) {
            String expectedDay1 = day.getText();
            if (expectedDay1.equals(expectedDayFormat)) {
                System.out.println("Day after tomorrow Date: " + expectedDayFormat);
                Thread.sleep(1000);
                day.click();
                break;
            }
        }
    }

    @Step
    public void selectCheckOutDay(int checkOutDays) throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, checkOutDays);
        Date expectedDay8 = c.getTime();
        System.out.println("Expected day" +expectedDay8);
        String expectedDayFormat7 = sdf.format(expectedDay8);
        //System.out.println("Formated day" +expectedDayFormat7 );
        clickOn(checkOutField);

        List<WebElement> co_days = SharedSD.getDriver().findElements(calendarPicker);
        for (WebElement day8 : co_days) {
            String expectedDay_week = day8.getText();
            if (expectedDay_week.equals(expectedDayFormat7)) {
                System.out.println("Eight Days after tomorrow Date: " + expectedDayFormat7);
                Thread.sleep(1000);
                day8.click();
                break;
            }
        }

    }

    public void selectMoreOptionsFromRooms(int option) {
        WebElement mySelectElement = SharedSD.getDriver().findElement(By.id("qf-0q-compact-occupancy"));
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByIndex(option);
        //dropdown.selectByVisibleText(option);
    }

    public void selectFromDropDownRoom(String choice ){
        WebElement mySelectElement = SharedSD.getDriver().findElement(dropDownLocatorRoom);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue(choice);

    }

    public void selectFromDropDownNumAdults(String choice ){
        WebElement mySelectElement = SharedSD.getDriver().findElement(dropDownLocatorNumAdults);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue(choice);
    }

    public void selectFromDropDownNumChildren(String choice ){
        WebElement mySelectElement = SharedSD.getDriver().findElement(dropDownLocatorNumChildren);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue(choice);
    }

    public void selectFromDropDownAgeChildOne(String choice ){
        WebElement mySelectElement = SharedSD.getDriver().findElement(dropDownLocatorAgeChild1);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue(choice);
    }

    public void selectFromDropDownAgeChildTwo(String choice ){
        WebElement mySelectElement = SharedSD.getDriver().findElement(dropDownLocatorAgeChild2);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue(choice);
    }

    public void clickOnSubmitButton() {
        clickOn(searchButton);
    }

    public void verifyHotelRoomPrice(){
        String price = getTextFromElement(pricePromo);
        System.out.println("Price String: " +price);

        String price_new = price.replace("$", "");
        System.out.println(price_new);

        int result = Integer.parseInt(price_new);
        System.out.println(result);
        if (result >200 && result < 300){
            System.out.println("Price is in the range");
        }
        else{
            System.out.println("Price is out of the range");
        }
    }
}
