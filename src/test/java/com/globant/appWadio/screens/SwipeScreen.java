package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

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

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    public String getLblLastCard() {
        return lblCompatible.getDomAttribute("text");
    }

    /**
     * This method is used to swipe horizontally.
     */
    public void swipeFromRightToLeft() {
        waitForElementToAppear(lblSwipeHorizontal);
        if (nextCardElements.isDisplayed() && actualCardElements.isDisplayed()) {
            swipeHorizontal(nextCardElements, actualCardElements);
            System.out.println("Swiped from right to left successfully.");
        }else {
            System.out.println("No more cards to swipe left.");
        }
    }
}
