package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import stepdefinition.SharedSD;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobileBasePage{

    /**
     * This is a constructor which initializes initPageElements()
     */
    public MobileBasePage() {
        initPageElements();
    }

    /**
     * This method handles wait functionality for mobile actions, which means if the element is not found
     * during test then the app will re-try and wait up to 15 seconds before failing the test step
     */
    protected void initPageElements() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumWrapper.getAppiumDriver(), 15, TimeUnit.SECONDS), this);
    }

    /**
     * This method is used to tap on element
     *
     * @param mobileElement element to tap on
     */
    protected void tapOn(MobileElement mobileElement) {
        try {
            mobileElement.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to set value in text field
     *
     * @param mobileElement
     * @param setValue
     */
    protected void setValue(MobileElement mobileElement, String setValue) {

        try {
            mobileElement.sendKeys(setValue);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
    }

    /**
     * This method is used to verify if element is displayed
     * @param mobileElement
     * @return
     */
    protected boolean isElementDisplayed(MobileElement mobileElement) {
       boolean isDisplayed;
        try {
            isDisplayed = mobileElement.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }

        return isDisplayed;
        //return false;
    }

    /**
     * This method is used to verify if element is enabled
     * @param mobileElement
     * @return
     */
    protected boolean isElementEnabled(MobileElement mobileElement){
        boolean isEnabled;
        try {
            isEnabled = mobileElement.isEnabled();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new NoSuchElementException("Unable to locate the Element using: " + mobileElement.toString());
        }
        return isEnabled;
    }


    /**
     * This method is used to verify if elements are selected
     * @param mobileElement
     * @return
     */
//    protected boolean isElementSelected (MobileElement mobileElement) {
//        try
//        {
//            List<MobileElement> myElements = AppiumWrapper.getAppiumDriver().findElementsByXPath("mobileElement");
//            for(MobileElement e : myElements) {
//                System.out.println("Element is selected" +e.isSelected());
//               return true;
//            }
//        } catch (NoSuchElementException ignored) {
//            System.out.println("Element not found");
//            return false;
//        }
//        return true;
//    }

    public void clickOnElement(List<MobileElement> toggleSwitch) {
        List<MobileElement> elementsOne = toggleSwitch;
        int i=0;
        for (MobileElement e : elementsOne) {
            i+=1;
            System.out.println("Element is selected " + e.isSelected() +"other" + e.getAttribute(""));

            if (i==1)
            {
                break;
            }
        }
    }

}
