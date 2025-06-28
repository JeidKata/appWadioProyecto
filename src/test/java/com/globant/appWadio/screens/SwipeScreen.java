package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Swipe horizontal\")")
    private WebElement lblSwipeHorizontal;

    @AndroidFindBy(uiAutomator = "description(\"card\").instance(0)")
    private WebElement actualCardElements;

    @AndroidFindBy(uiAutomator = "description(\"card\").instance(1)")
    private WebElement nextCardElements;

    @AndroidFindBy(accessibility = "card")
    private WebElement lastCardElement;

    @AndroidFindBy(uiAutomator = "text(\"COMPATIBLE\")")
    private WebElement lblCompatible;

    @AndroidFindBy(uiAutomator = "text(\"You found me!!!\")")
    private WebElement lblYouFoundMe;

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getLblLastCard() {
        waitForElementToAppear(lblCompatible);
        return lblCompatible.getDomAttribute("text");
    }

    public String getLblYouFoundMe() {
        waitForElementToAppear(lblYouFoundMe);
        return lblYouFoundMe.getDomAttribute("text");
    }

    /**
     * This method is used to swipe horizontally.
     * It will swipe from right to left until the next card is not displayed.
     */
    public void swipeFromRightToLeft() {
            waitForElementToAppear(lblSwipeHorizontal);
        try{
            while (nextCardElements.isDisplayed()) {
                swipeHorizontal(nextCardElements, actualCardElements);
                System.out.println("Swiped from right to left successfully.");
            }
        } catch (Exception e) {
            System.out.println("No more cards to swipe.");
        }
    }
}
