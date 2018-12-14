package framework.mobile_pages;

import framework.AppiumWrapper;
import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomePage extends MobileBasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    private MobileElement skipButton;

    @AndroidFindBy(accessibility = "options ")
    private MobileElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='Angular']")
    private MobileElement androidSlider;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Reset All Filters ']")
    private MobileElement allResetFilterButton;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private MobileElement checkboxes;

//  @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View[@content-desc='Angular']//following-sibling::android.widget.CheckBox")
//  private MobileElement allCheckBoxes;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View[@content-desc=‘Angular’]//following-sibling::android.widget.CheckBox")
    private List<MobileElement> toggleSwitch;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.widget.Button[@content-desc='CONTINUE arrow forward ']")
    private MobileElement continueButton;

    public boolean verifyIconDisplayed(){
        return isElementDisplayed(skipButton);
    }

    public void clickOnButton() throws InterruptedException {
        tapOn(skipButton);
        Thread.sleep(1000);
        tapOn(filterButton);
        Thread.sleep(1000);
    }

    public void disableOption() throws InterruptedException {
        tapOn(androidSlider);
    }

    public void clickOnAllResetButton() throws InterruptedException {
        tapOn(allResetFilterButton);
        Thread.sleep(1000);
    }

    public void verifyAllOptionsSelected(){
//        boolean enabled = false;
//        List<MobileElement> myElements = AppiumWrapper.getAppiumDriver().findElementsByXPath("//android.webkit.WebView/android.view.View[@content-desc='Angular']//following-sibling::android.widget.CheckBox");
//        for(MobileElement e : myElements) {
//            enabled = isElementEnabled(e);
//        }
//        return enabled;
       //return isElementSelected(allCheckBoxes);
        clickOnElement(toggleSwitch);
    }

    public void swipeTutorialslides(int num) throws InterruptedException {
        for (int i = 0; i < num; i++){
            Thread.sleep(8000);
            TouchAction touch = new TouchAction(AppiumWrapper.getAppiumDriver());
            Thread.sleep(100);
            touch.press(1200, 800).moveTo(200, 800).release().perform();
            Thread.sleep(900);
        }
        System.out.println("continue is not found");

    }

    public boolean continueButtonIsDisplayed(){
        return isElementDisplayed(continueButton);
    }
}
