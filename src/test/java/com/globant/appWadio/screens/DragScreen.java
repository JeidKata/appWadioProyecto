package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Drag and Drop\")")
    private WebElement lblDragAndDrop;

    public DragScreen(AppiumDriver driver) {
        super(driver);
    }

    /**
     * This method is used to wait for the Drag screen to load.
     * It checks for the presence of a specific element that indicates the Drag screen is ready.
     */
    public void waitForDragToLoad() {
        if (waitForElementToAppear(lblDragAndDrop)) {
            System.out.println("Drag screen loaded successfully.");
        } else {
            System.out.println("Drag screen did not load successfully.");
        }
    }

    /**
     * This method is used to check if the Drag and Drop label is visible.
     * It returns true if the label is visible, otherwise false.
     */
    public boolean isDragAndDropVisible() {
        return isElementVisible(lblDragAndDrop);
    }
}
