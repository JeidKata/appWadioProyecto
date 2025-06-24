package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "className(\"android.view.ViewGroup\").instance(6)")
    private WebElement webviewElement;

    @AndroidFindBy(accessibility = "Toggle navigation bar")
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
        if (waitForElementToAppear(webviewElement)) {
            System.out.println("Webview is loaded and ready.");
        } else {
            System.out.println("Webview did not load successfully.");
        }
    }

}
