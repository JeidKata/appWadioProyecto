package com.globant.appWadio.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    public AppiumDriver driver;
    protected static final int TIMEOUT = 10;
    protected WebDriverWait wait;

    public BaseScreen(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * This method is used to wait for an element to appear.
     */
    public boolean waitForElementToAppear(WebElement element) {
        try {
            WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
            return element1 != null;
        } catch (Exception e) {
            return false;
        }
    }
}
