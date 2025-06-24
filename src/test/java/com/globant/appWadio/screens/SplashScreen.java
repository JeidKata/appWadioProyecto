package com.globant.appWadio.screens;

import com.globant.appWadio.utils.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SplashScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "className(\"android.widget.ImageView\").instance(0)")
    private WebElement imgLogo;

    public SplashScreen(AppiumDriver driver){
        super(driver);
    }

    /**
     * This method is used to wait for the splash screen logo to disappear.
     */
    public void waitLogoAppears() {
        this.waitForElementToAppear(imgLogo);
        System.out.println("Logo has appeared.");
//        logs.info("Splash screen logo has disappeared.");
    }
}
