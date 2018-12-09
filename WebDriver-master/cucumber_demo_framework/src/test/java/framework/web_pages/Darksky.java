package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static stepdefinition.SharedSD.getDriver;

public class Darksky extends BasePage {
    private By searchField = By.xpath("//input[@type='text']");
    private By magnifyingGlass = By.xpath("//a[@class='searchButton']");
    private By tempResult = By.xpath("//span[@class='summary swap']");
    private By low = By.xpath("//span[@class='currently']//span[2]//span[2]//span[2]");
    private By high = By.xpath("//span[@class='summary-high-low']//span[3]");

    private By timeLine = By.xpath("//div[@id='timeline']//div[@class='hours']//span[1]");

    private By expandToday = By.xpath("//div[@id='week']//a[1]//span[1]//span[1]");
    private By minTemp = By.xpath("//span[@class='minTemp']");
    private By maxTemp = By.xpath("//span[@class='maxTemp']");
    private By lowtTemp = By.xpath(".//*[@class='highTemp swip']//span[1]");
    private By highTemp = By.xpath("//*[@class='lowTemp swap']/span[1]");

    private By timeMachineButton = By.xpath("//a[@class='button']");
    private By todaysDate = By.xpath("//td[@class='is-today']");


    public void clearField() {
        clearField(searchField);
    }

    public void sendText(String input) throws InterruptedException {
        sendText(searchField, input);
        Thread.sleep(2000);
    }

    public void clickOnSearch() throws InterruptedException {
        clickOn(magnifyingGlass);
        Thread.sleep(2000);
    }

    public void verifyTemperature() throws InterruptedException {
        String temp = getTextFromElement(tempResult);
        int currentTemp, lowTemp, highTemp;
        currentTemp = tempConversion(temp);

        String lTemp = getTextFromElement(low);
        lowTemp = tempConversion(lTemp);

        String hTemp = getTextFromElement(high);
        highTemp = tempConversion(hTemp);

        if (currentTemp <= highTemp && currentTemp >= lowTemp){
            System.out.println("Current temperature " +currentTemp+ " is within boundaries of Low " +lowTemp+ " and High " +highTemp);
        } else {
            System.out.println("Current temperature " +currentTemp+ " is outside of boundaries of Low " +lowTemp+ " and High " +highTemp);
        }

    }

    public int tempConversion(String tempStr) throws InterruptedException {
        String newTemp  = "";
        Thread.sleep(1000);

        for(int i = 0; i < tempStr.length(); i++){
            if(Character.isDigit(tempStr.charAt(i))){
                newTemp += tempStr.charAt(i);
            }
        }

        int temperature = Integer.parseInt(newTemp);
        return temperature;
    }


    public void verifyTimeline() throws InterruptedException {
        String timePlusTwo = "", hour = "";
        List<String> plustwo= new ArrayList<>();
        List<String> timeline= new ArrayList<>();

        Calendar time = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ha");
        String currentTime = sdf.format(time.getTime()).toLowerCase();

        for (int t = 2; t < 24; t += 2) {
            Calendar newTime = Calendar.getInstance();
            newTime.add(Calendar.HOUR, t);
            timePlusTwo = sdf.format(newTime.getTime()).toLowerCase();

            plustwo.add(timePlusTwo);
        }

        // System.out.println("\nTime line: ");
        Thread.sleep(2000);
        for (int i = 3; i < 25; i += 2) {
            hour = getDriver().findElement(By.xpath("//div[@id='timeline']//div[@class='hours']//span[" + i + "]")).getText();

            timeline.add(hour);
        }

        if (plustwo.equals(timeline)) {
            Assert.assertEquals(plustwo,timeline);
            System.out.println("PASS - Timeline is displayed with two hours incremented \nCurrent+2: " + plustwo + "\nTimeLine: " + timeline);
        } else {
            Assert.fail("FAIL - Timeline is NOT displayed with two hours incremented \nCurrent+2: " + plustwo + "\nTimeLine: " + timeline);
            //System.out.println("FAIL - Timeline is NOT displayed with two hours incremented \nCurrent+2: " + plustwo + "\nTimeLine: " + timeline);
        }
    }

    public void expandTodaysTimeLine() throws InterruptedException {
        //scrollOnPage();
        clickOn(expandToday);
    }
    public void verifyLowHighTemp(){

        String lTemp = getTextFromElement(minTemp);
        String low = getTextFromElement(lowtTemp);
        String hTemp = getTextFromElement(maxTemp);
        String high = getTextFromElement(highTemp);

        String newlTemp = tempToDigit(lTemp);
        String newhTemp = tempToDigit(hTemp);
        String newLowTemp = tempToDigit(low);
        String newHighTemp = tempToDigit(high);


        if(newlTemp.equals(newLowTemp) & newhTemp.equals(newHighTemp)){
//            Assert.assertEquals(newlTemp,newLowTemp);
//            Assert.assertEquals(newhTemp,newHighTemp);
            System.out.println("PASS - Temps is displayed correctly: " +newlTemp+ " = " +newLowTemp);
        }else{
            Assert.fail("Fail - Temps is NOT displayed correctly: " +newhTemp+ " != " +newHighTemp);
        }
    }

    public String tempToDigit (String temp){
        String number = "";
        String ch = "";
        for (int i = 0; i < temp.length(); i++) {
            char a = temp.charAt(i);
            if (Character.isDigit(a)) {
                number = number + a;
            }else{
             ch += a;
            }
        }
        return number;
    }

    public void clickOnTimeMachine() throws InterruptedException {
        clickOn(timeMachineButton);
        Thread.sleep(2000);
    }

    public String verifyTodayIsSelected(){
        String dateCal = getTextFromElement(todaysDate);
        return dateCal;
    }
    public String todayDate() {
        String today = currentDate("d");
        return today;
    }

}