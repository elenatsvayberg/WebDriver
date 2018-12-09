package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HerokuLogin extends BasePage {

    private By email = By.xpath("//input[@id='email']");
    private By pwd = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By image = By.xpath("//a[@class='dropdown-toggle']//img[@class='img-circle']");
    private By logoutOption = By.xpath("//a[contains(text(),'Logout')]");

    public void enterCredentials(String username, String password) throws InterruptedException {
        clickOn(email);
        sendText(email, username);
        clickOn(pwd);
        sendText(pwd, password);
        Thread.sleep(2000);
    }

    public void submit() throws InterruptedException {
        clickOn(submitButton);
        Thread.sleep(2000);
    }

    public String verifyLogoutButtondisplayed(String logout){
        clickOn(image);
        String option = getTextFromElement(logoutOption);
        return option;
    }
}
