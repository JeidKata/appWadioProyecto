package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
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

    private final List<String> cardElementIds;

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
        this.cardElementIds = new ArrayList<>();
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
    public void swipeCards() {
            waitForElementToAppear(lblSwipeHorizontal);
        try{
            int i = 0;
            while (isElementVisible(nextCardElements)) {
                System.out.println("\tCard: " + (i+1) + " displayed ");
                saveElementId();
                swipeHorizontal(nextCardElements, actualCardElements);
                i ++;
                String s = (isElementVisible(nextCardElements)) ? "Successful sliding." : "This is the last card.";
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("No more cards to swipe.");
        }
    }

    /**
     * This method saves the ID of the actual card element.
     * It checks if the element is visible before attempting to retrieve its ID.
     */
    public void saveElementId() {
        try {
            if (isElementVisible(actualCardElements)) {
                String elementId = ((RemoteWebElement) actualCardElements).getId();
                cardElementIds.add(elementId);
                isCardHidden();
            } else {
                System.out.println("The element is not visible.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving element ID: " + e.getMessage());
        }
    }

    /**
     * This method checks if the actual card is hidden.
     */
    public void isCardHidden() {
        try{
           if(isElementVisible(actualCardElements)) {
               for (int i = 0; i < cardElementIds.size(); i++) {
                   if (i == cardElementIds.size() - 2) {
                       System.out.println("\tCard: " + (i+1) + " is hidden.");
                   }
               }
           }
        }catch (Exception e) {
            System.out.println("Error checking if card is hidden: " + e.getMessage());
        }
    }

    /**
     * This method verifies if the last card is displayed.
     */
    public boolean isLastCardDisplayed() {
        try {
            return isElementVisible(lastCardElement);
        } catch (NoSuchElementException e) {
            System.out.println("The last card is not displayed.");
            return false;
        }
    }

    public void swipeBottomToTop() {
        while (!isElementVisible(lblYouFoundMe)) {
            swipeVertical();
            String message = isElementVisible(lblYouFoundMe) ? "The robot's message was found." : "Looking for the robot's message.";
            System.out.println(message);
        }
    }
}
