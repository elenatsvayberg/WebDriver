package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class HerokuRegistration extends BasePage {

    private By nameField = By.xpath("//input[@name='username']");
    private By emailField = By.xpath("//input[@name='email']");
    private By pwdField = By.xpath(" //input[@name='password']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By alert = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    //private By errorMessage = By.xpath("/html/body//form[@role='form']/div[3]");

    private By errorMessage = By.xpath("//*[contains(text(), ‘@’)]");

    public void enterCredentials(String name, String email, String password) throws InterruptedException {
        sendText(nameField, name);
        sendText(emailField, email);
        sendText(pwdField, password);
        Thread.sleep(2000);
    }

    public void submit() throws InterruptedException {
        clickOn(submitButton);
        Thread.sleep(1000);
    }

    public String verifySignin(){
        String retAlert = getTextFromElement(alert);
        return retAlert;
    }

    public void submitButton() throws InterruptedException {
        clickOn(submitButton);
        Thread.sleep(2000);
    }

    public void verifyInvalidMessage() throws InterruptedException {
//        String retMessage = getTextFromElement(errorMessage);
//        //String alert = SharedSD.getDriver().switchTo().alert().getText();
//        System.out.println("Error: " +retMessage);
//        Thread.sleep(2000);
//        Assert.assertEquals(alert, "Please include @");

        //if (//textContains("Please include @")

        //SharedSD.getDriver().findElement(By.xpath(By.xpath(“//*[contains(text(),"Please include @")]“));


        //Assert.assertTrue(SharedSD.getDriver().getPageSource(),conntains(“@”));
        getMessage(emailField);
    }

}
