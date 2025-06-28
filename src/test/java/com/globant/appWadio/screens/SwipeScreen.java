package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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

    private List<String> textActualCard;

    private String elementId;

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
        this.textActualCard = new java.util.ArrayList<>();
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
            while (isElementVisible(nextCardElements)) {
                System.out.println("\tCard: " + (i+1) + " displayed ");
                saveElementId();
                swipeHorizontal(nextCardElements, actualCardElements);
                System.out.println("Swiped from right to left successfully.");
                i ++;
            }
        } catch (Exception e) {
            System.out.println("No more cards to swipe.");
        }
    }

    public void saveElementId() {
        try {
            if (isElementVisible(actualCardElements)) {
                String elementId = ((RemoteWebElement) actualCardElements).getId();
                textActualCard.add(elementId);
                isCardHidden();
            } else {
                System.out.println("The element is not visible.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving element ID: " + e.getMessage());
        }
    }
//
//    public void getTextCurrentCard() {
//        try {
//            if (isElementVisible(actualCardElements)) {
//                String elementId = ((RemoteWebElement) actualCardElements).getId();
//                textActualCard.add(elementId);
//                System.out.println(textActualCard);
//                System.out.println("Current card elementId: " + elementId);
//            } else {
//                textActualCard.get(textActualCard.indexOf(actualCardElements.getDomAttribute("elementId"))-1);
//                System.out.println("The current card is not visible.");
//            }
//        } catch (Exception e) {
//            System.out.println("Error. "+ e);
//        }
//    }

    /**
     * Este metodo se utiliza paraque compruebe que la tarjeta antigua está oculta.
     */
    public void isCardHidden() {
        try{
           if(isElementVisible(actualCardElements)) {
               for (int i = 0; i < textActualCard.size(); i++) {
                   String id = textActualCard.get(i);
                   if (i == textActualCard.size() - 2) {
                       System.out.println("La carta con el ID " + id + " está oculta.");
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
            return lastCardElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("The last card is not displayed.");
            return false;
        }
    }
}
