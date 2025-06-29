package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Form components\")")
    private WebElement lblFormComponents;

    public FormsScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is used to wait for the Forms screen to load.
     * It checks for the presence of a specific element that indicates the Forms screen is ready.
     */
    public void waitForFormsToLoad() {
        if (waitForElementToAppear(lblFormComponents)) {
            System.out.println("Forms screen is loaded and ready.");
        } else {
            System.out.println("Forms screen did not load successfully.");
        }
    }

    /**
     * This method is used to check if the Forms screen is visible.
     */
    public boolean isFormsVisible() {
        return isElementVisible(lblFormComponents);
    }
}
