package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.List;

public class HerokuHome extends BasePage {

    private By searchField = By.id("aa-search-input");
    private By searchResult = By.id("algolia-autocomplete-listbox-0");

    private By posts = By.xpath(".//*[@class='col-md-3']");
    private By price = By.xpath(".//*[@class='gig-card']//h3");
    private By title = By.xpath(".//*[@class='gig-card']//h4");
    private By image = By.xpath(".//*[@class='gig-card']//img");


    public void searchHeroku(String input) throws InterruptedException {
        sendText(searchField, input);
        Thread.sleep(2000);
    }

    public String verifyTitle(){
        String searchRes = getTextFromElement(searchResult);
        return searchRes;
    }

    public int verifyNumPosts(){
        int count = 0;
        List<WebElement> postList = SharedSD.getDriver().findElements(posts);
        for (int i = 0; i < postList.size(); i++ ){
            count ++;
        }
        System.out.println("Total Number Of Posts: " + count);
        return count;
    }

    public int verifyPostsWithPrice(){
        int count = 0;
        List<WebElement> priceList = SharedSD.getDriver().findElements(price);
        for (int i = 0; i < priceList.size(); i++ ){
            if (!priceList.get(i).getText().equals("$")){
                count++;
            }
        }
        System.out.println("Number Of Posts Have Price: " + count);
        return count;
    }

    public int verifyPostsHaveTitle(){
        int count = 0;
        List<WebElement> titleList = SharedSD.getDriver().findElements(title);
        for (int i = 0; i < titleList.size(); i++) {
            if(!titleList.get(i).getText().equals("")){
                count++;
            }
        }
        System.out.println("Number Of Posts Have Title: " + count);
        return count;
    }

    public int verifyPostsHaveImage(){
        int count = 0;
        List<WebElement> imageList = SharedSD.getDriver().findElements(image);
        for (int i = 0; i < imageList.size(); i++) {
            if(imageList.get(i).isDisplayed()){
                count++;
            }
        }
        System.out.println("Number Of Posts Have Image: " + count);
        return count;
    }

}
