package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @AndroidFindBy(id = "__CAROUSEL_ITEM_0_READY__")
    private WebElement carouselItem;

    private List<WebElement> carouselItems;

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
            int i = 0;
            while (nextCardElements.isDisplayed()) {
                System.out.println("\tCard: " + (i+1) + " displayed ");
                swipeHorizontal(nextCardElements, actualCardElements);
                getCurrentCard();
                System.out.println("Swiped from right to left successfully.");
                i ++;
            }
        } catch (Exception e) {
            System.out.println("No more cards to swipe.");
        }
    }

    public int getCurrentCard() {
        waitForElementToAppear(carouselItem);
        String resourceId = carouselItem.getDomAttribute("resource-id");
        WebElement newCarrouselItem = driver.findElement(By.id(resourceId));
        carouselItems.add(newCarrouselItem);
        return carouselItems.size();
    }
}
