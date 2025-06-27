package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;

public class SwipeScreen extends BaseScreen {
    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is used to swipe left on the screen.
     */
    public void swipeLeft() {
        // Implement swipe left logic here
        System.out.println("Swiping left on the screen.");
    }

    /**
     * This method is used to swipe right on the screen.
     */
    public void swipeRight() {
        // Implement swipe right logic here
        System.out.println("Swiping right on the screen.");
    }
}
