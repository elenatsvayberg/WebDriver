package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;

public class HotelsHomePage extends BasePage {

    private By pageHeader = By.id("");
    private By gpsButton = By.id("");
    private By destinationTextField = By.id("");

    public String getPageHeader() {
        return getTextFromElement(pageHeader);
    }

    public void clickOnGpsButton() {
        clickOn(gpsButton);
    }

    public String getDestiatinoFieldText() {
        return getTextFromElement(destinationTextField);
    }
}
