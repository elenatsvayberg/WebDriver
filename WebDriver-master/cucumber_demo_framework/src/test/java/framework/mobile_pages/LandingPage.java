package framework.mobile_pages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.testng.annotations.Test;

public class LandingPage extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='SKIP ']")
    // (xpath = "//android.webkit.WebView/android.widget.TabWidget/)
    //(accessibility = "close share")
    //(className = "android.widget.EditText")
    //(id="android:id/statusBarBackground")
    @iOSFindBy(accessibility = "yesButton")
    private MobileElement yesButton;

    @AndroidFindBy(xpath= "//android.webkit.WebView/android.view.View/android.widget.Button[1]")
    private MobileElement mainMenu;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Menu']")
    private MobileElement sidebarHeader;

    @AndroidFindBy(accessibility = "FAVORITES ")
    private MobileElement favoritesButton;

    @AndroidFindBy(accessibility = "No Sessions Found")
    public MobileElement textDisplayed;

    public void tapOnSkipButton() {
        tapOn(yesButton);
    }

    public void tapOnMainMenuButton() {
        tapOn(mainMenu);
    }

    public boolean isSideMenuBarDisplayed() {
        return isElementDisplayed(sidebarHeader);
    }

    public void iClickOnFavoritesButton(){
        tapOn(favoritesButton);
    }

    public boolean iVerifyTextDisplayed(){
        return isElementDisplayed(textDisplayed);
    }



}
