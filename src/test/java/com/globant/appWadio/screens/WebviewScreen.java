package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    private WebElement lblWebview;

    @AndroidFindBy(uiAutomator = "text(\"Toggle navigation bar")
    private WebElement btnToggleNavigationBar;

    @AndroidFindBy(uiAutomator = "text(\"openjs_foundation-logo-horizontal-color-dark_background\")")
    private WebElement webviewLogoElement;

    public WebviewScreen(AppiumDriver driver){
        super(driver);
    }

    /**
     * This method is used to wait for the Webview screen to load.
     * It checks for the presence of a specific element that indicates the Webview is ready.
     */
    public void waitForWebviewToLoad() {
        String message = (waitForElementToAppear(lblWebview))?
                "Webview loaded successfully." :
                "Webview did not load successfully.";
        System.out.println(message);
    }

    /**
     * This method is used to check if the Webview logo is visible.
     * It returns true if the logo is visible, otherwise false.
     */
    public boolean isWebviewTitleVisible() {
        try {
            return waitForElementToAppear(lblWebview);
        } catch (Exception e) {
            System.out.println("Webview title is not visible: " + e.getMessage());
            return false;
        }
    }
}
